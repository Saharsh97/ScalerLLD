package com.scaler.bookmyshow;

import com.scaler.bookmyshow.controllers.UserController;
import com.scaler.bookmyshow.controllers.dto.LoginRequestDTO;
import com.scaler.bookmyshow.controllers.dto.LoginResponseDTO;
import com.scaler.bookmyshow.controllers.dto.SignUpRequestDTO;
import com.scaler.bookmyshow.controllers.dto.SignUpResponseDTO;
import com.scaler.bookmyshow.models.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

@SpringBootApplication
// to enable Command Line input

@EnableJpaAuditing
// whenever a change happens, like a new row
// save that the information.
// I will save that info to the BaseModel attributes
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    @Override
    // you can run, whatever you want to run.
    // give your own inputs.
    public void run(String... args) throws Exception {
//        SignUpRequestDTO requestDTO = new SignUpRequestDTO();
//        requestDTO.setEmail("saharsh.singh2@scaler.com");
//        requestDTO.setPassword("password");
//
//        SignUpResponseDTO responseDTO = userController.signup(requestDTO);
//        System.out.println("userId: " + responseDTO.getUserId());
//        System.out.println("status : " + responseDTO.getStatus());


        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setEmail("saharsh.singh2@scaler.com");
        requestDTO.setPassword("password222");

        LoginResponseDTO responseDTO = userController.login(requestDTO);
        System.out.println("userId : " + responseDTO.getUserId());
        System.out.println("status : " + responseDTO.getStatus());
    }

    public static void main(String[] args) {
        BaseModel baseModel = new BaseModel();
        baseModel.getId();
        SpringApplication.run(BookMyShowApplication.class, args);
    }
}
