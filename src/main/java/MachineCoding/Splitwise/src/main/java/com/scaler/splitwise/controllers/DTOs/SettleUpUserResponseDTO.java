package com.scaler.splitwise.controllers.DTOs;

import com.scaler.splitwise.controllers.enums.ResponseStatus;
import com.scaler.splitwise.models.Expense;

import java.util.List;

public class SettleUpUserResponseDTO {
    private ResponseStatus responseStatus;
    private List<Expense> settleUpTransactions;
}
