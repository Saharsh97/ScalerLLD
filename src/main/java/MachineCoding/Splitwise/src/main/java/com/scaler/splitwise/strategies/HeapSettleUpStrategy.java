package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.Transaction;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.models.UserExpense;
import com.scaler.splitwise.models.enums.ExpenseType;
import com.scaler.splitwise.models.enums.TransactionStatus;
import com.scaler.splitwise.models.enums.UserExpenseType;
import org.springframework.data.util.Pair;

import java.util.*;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expensesToSettleUp) {
        List<Transaction> settleUpTransactions = new ArrayList<>();

        // Real expense -> added by the users
        // Reverse Expense -> was added to nullify a completed transaction.
        // 0. from the reverse expense, I want to directly add them to list.
        // lets add the completed transactions.
        // these are Expenses marked by SETTLE_UP_TRANSACTION
        // these are reverse expenses
        for(Expense expense: expensesToSettleUp) {   // for all expenses, real or reverse
            if (expense.getExpenseType() == ExpenseType.SETTLE_UP_TRANSACTION) {
                settleUpTransactions.add(getCompletedTransactionFromReverseExpense(expense));
            }
        }

        // 1. get the final amount on each person!
        // Go through all the expenses
            // go through the userExpenseList
                // if type == PAID
                    // finalAmount[user] += amount
                // else
                    // finalAmount[user] -= amount
        Map<User, Integer> finalAmount = new HashMap<>();
        for(Expense expense: expensesToSettleUp) {
            for(UserExpense userExpense : expense.getUserExpenseList()){    // for this expense, whoPaid and whoHadToPay
                User user = userExpense.getUser();
                Integer existingAmountOnThisPerson = finalAmount.getOrDefault(user, 0);
                if(userExpense.getUserExpenseType() == UserExpenseType.PAID_BY){
                    existingAmountOnThisPerson += userExpense.getAmount();
                } else {
                    existingAmountOnThisPerson -= userExpense.getAmount();
                }
                finalAmount.put(userExpense.getUser(), existingAmountOnThisPerson);
            }
        }

        // create 2 priority queues.
        PriorityQueue<Pair<User, Integer>> getterQueue = new PriorityQueue<>(finalAmount.size(), Collections.reverseOrder());
        PriorityQueue<Pair<User, Integer>> payerQueue = new PriorityQueue<>(finalAmount.size());

        // iterate over finalCount map, add user to each queue.
        for(Map.Entry<User, Integer> entry: finalAmount.entrySet()){
            if(entry.getValue() > 0){
                getterQueue.add(Pair.of(entry.getKey(), entry.getValue()));
            } else {
                payerQueue.add(Pair.of(entry.getKey(), entry.getValue()));
            }
        }

        // while(PQs.notEmpty()){
        //      max from PQ1 : Paid : A : receiveValue
        //      min from PQ2 : HadToPay : B : payValue
        // transaction from B->A, amount min(abs(receiveValue), abs(payValue))
        while(getterQueue.size() > 0 && payerQueue.size() > 0){
            Pair<User, Integer> X = getterQueue.poll();
            Pair<User, Integer> Y = payerQueue.poll();
            Integer payAmount = Math.min(Math.abs(X.getSecond()), Math.abs(Y.getSecond()));

            if(X.getSecond()-payAmount > 0) {
                Pair<User, Integer> updatedX = Pair.of(X.getFirst(), X.getSecond() - payAmount);
                getterQueue.add(updatedX);
            }
            if(Y.getSecond()+payAmount < 0){
                Pair<User, Integer> updatedY = Pair.of(Y.getFirst(), Y.getSecond() + payAmount);
                payerQueue.add(updatedY);
            }
            Transaction transactionToBeDone = new Transaction(Y.getFirst(), X.getFirst(), payAmount, TransactionStatus.PENDING);
            settleUpTransactions.add(transactionToBeDone);
        }
        return settleUpTransactions;
    }

    private Transaction getCompletedTransactionFromReverseExpense(Expense expense){
        Transaction completedTransaction = new Transaction();
        completedTransaction.setAmount(expense.getAmount());
        completedTransaction.setTransactionStatus(TransactionStatus.DONE);
        completedTransaction.setReceivingUser(expense.getUserExpenseList().stream().filter(userExpense -> userExpense.getUserExpenseType()==UserExpenseType.PAID_BY).findFirst().get().getUser());
        completedTransaction.setPayingUser(expense.getUserExpenseList().stream().filter(userExpense -> userExpense.getUserExpenseType()==UserExpenseType.HAD_TO_PAY).findFirst().get().getUser());
        return completedTransaction;
    }
}
