package com.scaler.splitwise.commands;

import com.scaler.splitwise.controllers.DTOs.SettleUpGroupRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpGroupResponseDTO;
import com.scaler.splitwise.controllers.SettleUpController;
import org.springframework.beans.factory.annotation.Autowired;

public class SettleUpGroupCommand implements Command{

    private SettleUpController settleUpController;

    @Autowired
    public SettleUpGroupCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        // input: SettleUpGroup groupId
        // input: SettleUpUser userId
        // input: Register name phoneNumber password.
        String[] words = input.split(" ");
        if(words[0].equals("SettleUpGroup")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        // input: SettleUpGroup groupId
        String[] words = input.split(" ");
        Long groupId = Long.valueOf(words[1]);

        SettleUpGroupRequestDTO requestDTO = new SettleUpGroupRequestDTO();
        requestDTO.setGroupId(groupId);

        SettleUpGroupResponseDTO responseDTO = settleUpController.settleUpGroup(requestDTO);
        System.out.println(responseDTO.getResponseStatus());
        System.out.println(responseDTO.getSettleUpTransactions());
    }
}
