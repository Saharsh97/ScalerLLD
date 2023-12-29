package com.scaler.bookmyshow.controllers.dto;

import com.scaler.bookmyshow.controllers.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {
    private Long userId;
    private ResponseStatus status;
}
