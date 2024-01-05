package com.scaler.splitwise.commands;

import com.scaler.splitwise.controllers.DTOs.SettleUpUserRequestDTO;
import com.scaler.splitwise.controllers.DTOs.SettleUpUserResponseDTO;
import com.scaler.splitwise.controllers.SettleUpController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SettleUpUserCommand implements Command{

    private SettleUpController settleUpController;

    @Autowired
    public SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        // input: SettleUp userId
        String[] words = input.split(" ");
        if(words.length == 2 && words[0].equals("SettleUp")){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        String[] words = input.split(" ");
        Long userId = Long.valueOf(words[1]);

        // now call the controller.
        // controller will be called by passing what? DTO
        SettleUpUserRequestDTO settleUpUserRequestDTO = new SettleUpUserRequestDTO();
        settleUpUserRequestDTO.setUserId(userId);

        // to call the controller, we need to inject the controller.
        SettleUpUserResponseDTO settleUpUserResponseDTO = settleUpController.settleUpUser(settleUpUserRequestDTO);
        System.out.println(settleUpUserResponseDTO.getResponseStatus());
    }
}
