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

@EnableJpaAuditing // create events, whenever DB update happens
@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    // book => Completed
    // signup
    // login

    @Autowired
    private UserController userController;

    @Override
    public void run(String... args) throws Exception {
//        SignUpRequestDTO requestDTO = new SignUpRequestDTO();
//        requestDTO.setEmail("shiva_1@scaler.com");
//        requestDTO.setPassword("123456");
//        requestDTO.setUserName("Shiva");
//
//        SignUpResponseDTO responseDTO = userController.signup(requestDTO);
//        System.out.println("status is : " + responseDTO.getStatus());
//        System.out.println("assigned userId is: " + responseDTO.getUserId());


        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setEmail("shiva_1@scaler.com");
        requestDTO.setPassword("123456");

        LoginResponseDTO responseDTO = userController.login(requestDTO);
        System.out.println("status is : " + responseDTO.getStatus());
        System.out.println("logged userId is: " + responseDTO.getUserId());
        System.out.println("error message is: " + responseDTO.getErrorMessage());
    }

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }
}
