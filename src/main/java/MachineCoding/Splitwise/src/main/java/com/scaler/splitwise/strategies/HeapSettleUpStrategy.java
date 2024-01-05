package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Expense> settleUp(List<Expense> expensesToSettleUp) {
        // homework to do. refer splitwise class 1.

        // Go through all the expenses
            // go through the userExpenseList
                // if type == PAID
                    // finalCount[user] += amount
                // else
                    // finalCount[user] -= amount

        // create 2 priority queues.
        // iterate over finalCount map, add user to each queue.


        // while(PQs.notEmpty()){
        //      max from PQ1 : Paid : A : receiveValue
        //      min from PQ2 : HadToPay : B : payValue
        // transaction from B->A, amount min(abs(receiveValue), abs(payValue))


        return null;
    }
}
