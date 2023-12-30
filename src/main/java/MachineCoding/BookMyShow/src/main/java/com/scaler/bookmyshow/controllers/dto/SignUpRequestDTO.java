package com.scaler.bookmyshow.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDTO {
    private String userName;
    private String email;
    private String password;

}
