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
        // SettleUpGroup groupId
        String[] words = input.split(" ");
        if(words.length == 2 && words[0].equals("SettleUpGroup")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        Long groupId = Long.valueOf(words[1]);

        // now call the controller.
        // controller will be called by passing what? DTO
        SettleUpGroupRequestDTO settleUpUserRequestDTO = new SettleUpGroupRequestDTO();
        settleUpUserRequestDTO.setGroupId(groupId);

        // to call the controller, we need to inject the controller.
        SettleUpGroupResponseDTO settleUpUserResponseDTO = settleUpController.settleUpGroup(settleUpUserRequestDTO);
        System.out.println(settleUpUserResponseDTO.getResponseStatus());
    }
}
