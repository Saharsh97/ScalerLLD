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
// 1. login flow.
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // 2. take what and response what? DTOs
    public SignUpResponseDTO signup(SignUpRequestDTO requestDTO){
        SignUpResponseDTO responseDTO = new SignUpResponseDTO();
        try{
            User savedUser = userService.signup(
                                requestDTO.getEmail(),
                                requestDTO.getPassword()
                            );

            responseDTO.setUserId(savedUser.getId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    public LoginResponseDTO login(LoginRequestDTO requestDTO){
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        try{
            User loggedInUser = userService.login(
                    requestDTO.getEmail(),
                    requestDTO.getPassword()
            );

            responseDTO.setUserId(loggedInUser.getId());
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
