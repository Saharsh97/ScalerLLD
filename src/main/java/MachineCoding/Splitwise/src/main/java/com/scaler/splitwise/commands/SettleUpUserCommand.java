package com.scaler.splitwise.commands;

import com.scaler.splitwise.controllers.DTOs.SettleUpGroupRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpGroupResponseDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpUserRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpUserResponseDTO;
import com.scaler.splitwise.controllers.SettleUpController;
import org.springframework.beans.factory.annotation.Autowired;

public class SettleUpUserCommand implements Command{

    private SettleUpController settleUpController;

    @Autowired
    public SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        // input: SettleUpGroup groupId
        // input: SettleUpUser userId
        // input: Register name phoneNumber password.
        String[] words = input.split(" ");
        if(words[0].equals("SettleUpUser")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        // input: SettleUpUser userId
        String[] words = input.split(" ");
        Long userId = Long.valueOf(words[1]);

        SettleUpUserRequestDTO requestDTO = new SettleUpUserRequestDTO();
        requestDTO.setUserId(userId);

        SettleUpUserResponseDTO responseDTO = settleUpController.settleUpUser(requestDTO);
        System.out.println(responseDTO.getResponseStatus());
        System.out.println(responseDTO.getSettleUpTransactions());
    }
}
