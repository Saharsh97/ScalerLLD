package com.scaler.splitwise.repositories;

import com.scaler.splitwise.models.User;
import com.scaler.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
    public List<UserExpense> findAllByUser(User user);
}
