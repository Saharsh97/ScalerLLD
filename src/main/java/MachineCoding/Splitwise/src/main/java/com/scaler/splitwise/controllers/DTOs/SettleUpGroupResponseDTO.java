package com.scaler.splitwise.controllers.DTOs;

import com.scaler.splitwise.controllers.enums.ResponseStatus;
import com.scaler.splitwise.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDTO {
    private ResponseStatus responseStatus;
    private List<Expense> settleUpTransactions;
    // can use List<TransactionDTO>
}
