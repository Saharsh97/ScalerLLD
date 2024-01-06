package com.scaler.splitwise.models;

import com.scaler.splitwise.models.enums.UserExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class  UserExpense extends BaseModel {
    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}

// expense1: whoPaid: A = 500, B = 300
//       whoHadToPay: A = 100 B = 100 C = 600
