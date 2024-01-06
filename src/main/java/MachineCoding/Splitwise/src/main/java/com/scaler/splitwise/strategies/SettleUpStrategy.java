package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.Transaction;

import java.util.List;

public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}
