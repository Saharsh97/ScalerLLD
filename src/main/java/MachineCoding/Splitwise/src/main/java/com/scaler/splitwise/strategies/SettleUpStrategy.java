package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// @component is parent class
// @controller, @service are more specific components,
public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}
