package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.models.UserExpense;
import com.scaler.splitwise.models.enums.ExpenseType;
import com.scaler.splitwise.models.enums.UserExpenseType;
import org.springframework.data.util.Pair;

import java.util.*;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettleUp) {
        // homework to do. refer splitwise class 1.

        // Go through all the expenses
            // go through the userExpenseList
                // if type == PAID
                    // finalAmount[user] += amount
                // else
                    // finalAmount[user] -= amount

        Map<User, Integer> finalAmount = new HashMap<>();
        for(Expense expense: expensesToSettleUp){   // for all expenses, real or reverse
            for(UserExpense userExpense : expense.getUserExpenseList()){    // for this expense, whoPaid and whoHadToPay
                User user = userExpense.getUser();
                Integer existingAmountOnThisPerson = finalAmount.getOrDefault(user, 0);
                if(userExpense.getUserExpenseType() == UserExpenseType.PAID){
                    existingAmountOnThisPerson += userExpense.getAmount();
                } else {
                    existingAmountOnThisPerson -= userExpense.getAmount();
                }
                finalAmount.put(userExpense.getUser(), existingAmountOnThisPerson);
            }
        }

        // create 2 priority queues.
        PriorityQueue<Pair<User, Integer>> getterMaxQueue = new PriorityQueue<>(finalAmount.size(), Collections.reverseOrder());
        PriorityQueue<Pair<User, Integer>> payerMaxQueue = new PriorityQueue<>();


        // iterate over finalCount map, add user to each queue.
        for(Map.Entry<User, Integer> entry: finalAmount.entrySet()){
            if(entry.getValue() > 0){
                getterMaxQueue.add(Pair.of(entry.getKey(), entry.getValue()));
            } else {
                payerMaxQueue.add(Pair.of(entry.getKey(), entry.getValue()));
            }
        }


        List<Expense> settleUpTransactions = new ArrayList<>();
        while(getterMaxQueue.size() > 0 && payerMaxQueue.size() > 0){
            Pair<User, Integer> X = getterMaxQueue.poll();
            Pair<User, Integer> Y = payerMaxQueue.poll();

            Integer payAmount = Math.min(Math.abs(X.getSecond()), Math.abs(Y.getSecond()));
            if(X.getSecond()-payAmount > 0) {
                Pair<User, Integer> updatedX = Pair.of(X.getFirst(), X.getSecond() - payAmount);
                getterMaxQueue.add(updatedX);
            }
            if(Y.getSecond()+payAmount < 0){
                Pair<User, Integer> updatedY = Pair.of(Y.getFirst(), Y.getSecond() + payAmount);
                payerMaxQueue.add(updatedY);
            }

            Expense transactionToBeDone = new Expense();
            transactionToBeDone.setAmount(payAmount);
            transactionToBeDone.setExpenseType(ExpenseType.REAL);

            settleUpTransactions.add(new Expense());
        }

        // while(PQs.notEmpty()){
        //      max from PQ1 : Paid : A : receiveValue
        //      min from PQ2 : HadToPay : B : payValue
        // transaction from B->A, amount min(abs(receiveValue), abs(payValue))


        return null;
    }
}
