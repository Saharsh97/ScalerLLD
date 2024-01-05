package com.scaler.splitwise.controllers.DTOs;

import com.scaler.splitwise.controllers.enums.ResponseStatus;
import com.scaler.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpUserResponseDTO {
    private ResponseStatus responseStatus;
    private List<Transaction> settleUpTransactions;
}
