package com.scaler.splitwise.models;

import com.scaler.splitwise.models.enums.ExpenseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter // these are like annotations
@Entity
public class Expense extends BaseModel{
    private String description;
    private int amount;

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany
    private List<UserExpense> userExpenseList;
}

// Expense  UserExpense
// 1        M
// 1        1

// 1:M

// expense1: whoPaid: A = 500, B = 300
//       whoHadToPay: A = 100 B = 100 C = 600


// expense2: whoPaid: A = 1000, B = 500
