package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.controllers.dto.LoginRequestDTO;
import com.scaler.bookmyshow.controllers.dto.LoginResponseDTO;
import com.scaler.bookmyshow.controllers.dto.SignUpRequestDTO;
import com.scaler.bookmyshow.controllers.dto.SignUpResponseDTO;
import com.scaler.bookmyshow.controllers.enums.ResponseStatus;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    public SignUpResponseDTO signup(SignUpRequestDTO requestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();

        try{
            User registeredUser = userService.signup(
                    requestDTO.getEmail(),
                    requestDTO.getUserName(),
                    requestDTO.getPassword());

            responseDTO.setUserId(registeredUser.getId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }


    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        LoginResponseDTO responseDTO = new LoginResponseDTO();

        try{
            User registeredUser = userService.login(
                    requestDTO.getEmail(),
                    requestDTO.getPassword());

            responseDTO.setUserId(registeredUser.getId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setErrorMessage(e.getMessage());
        }
        return responseDTO;
    }

}
