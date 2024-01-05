package com.scaler.splitwise.controllers;

import com.scaler.splitwise.controllers.DTOs.SettleUpGroupRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpGroupResponseDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpUserRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpUserResponseDTO;
import com.scaler.splitwise.controllers.enums.ResponseStatus;
import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.service.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private SettleUpService settleUpService;

    @Autowired
    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO requestDTO){
        SettleUpUserResponseDTO responseDTO = new SettleUpUserResponseDTO();

        try{
            List<Expense> settleUpTransactions = settleUpService.settleUpUser(requestDTO.getUserId());

            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setSettleUpTransactions(settleUpTransactions);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO requestDTO){
        SettleUpGroupResponseDTO responseDTO = new SettleUpGroupResponseDTO();

        try{
            List<Expense> settleUpTransactions = settleUpService.settleUpGroup(requestDTO.getGroupId());

            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setSettleUpTransactions(settleUpTransactions);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
