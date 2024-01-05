package com.scaler.splitwise.strategies;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
// just like we mark the usual Controller, Service, Repository
// this is just a component that will be used.
// Controller is like a specific component. it has component in its code.
// Service is like a specific component.
// @Component refers to a generic component
// can replace @Repository with @Component
public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expensesToSettleUp);
}
