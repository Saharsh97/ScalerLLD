package com.scaler.splitwise.controllers;

import com.scaler.splitwise.controllers.DTOs.SettleUpGroupRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpGroupResponseDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpUserRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpUserResponseDTO;
import com.scaler.splitwise.controllers.enums.ResponseStatus;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    public SettleUpUserResponseDTO settleUpUser(SettleUpUserRequestDTO requestDTO){
        SettleUpUserResponseDTO responseDTO = new SettleUpUserResponseDTO();

        try{

        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    public SettleUpGroupResponseDTO settleUpGroup(SettleUpGroupRequestDTO requestDTO){
        SettleUpGroupResponseDTO responseDTO = new SettleUpGroupResponseDTO();

        try{

        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
