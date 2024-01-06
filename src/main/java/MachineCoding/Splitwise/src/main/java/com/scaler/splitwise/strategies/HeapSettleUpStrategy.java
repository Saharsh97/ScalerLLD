package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.Transaction;

import java.util.List;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {
        return null;
    }
}
