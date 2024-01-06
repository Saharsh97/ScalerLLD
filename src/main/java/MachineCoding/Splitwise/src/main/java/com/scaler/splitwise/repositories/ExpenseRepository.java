package com.scaler.splitwise.repositories;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    public List<Expense> findAllByGroup(Group group);
}
