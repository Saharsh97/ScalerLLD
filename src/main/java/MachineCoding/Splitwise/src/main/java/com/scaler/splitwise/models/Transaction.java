package com.scaler.splitwise.models;

import com.scaler.splitwise.models.enums.TransactionStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User payingUser;
    private User receivingUser;
    private Integer amount;
    private TransactionStatus transactionStatus;

    public Transaction(){}

    public Transaction(User payingUser, User receivingUser, Integer amount, TransactionStatus transactionStatus) {
        this.payingUser = payingUser;
        this.receivingUser = receivingUser;
        this.amount = amount;
        this.transactionStatus = transactionStatus;
    }
}
