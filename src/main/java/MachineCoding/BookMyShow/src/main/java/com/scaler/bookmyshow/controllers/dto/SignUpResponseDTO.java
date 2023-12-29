package com.scaler.bookmyshow.controllers.dto;

import com.scaler.bookmyshow.controllers.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private ResponseStatus status;
    // if success, I will assign a userId to this person.
    private Long userId;
}
