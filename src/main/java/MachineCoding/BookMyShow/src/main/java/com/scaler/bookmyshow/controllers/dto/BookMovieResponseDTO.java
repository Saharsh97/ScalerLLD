package com.scaler.bookmyshow.controllers.dto;

import com.scaler.bookmyshow.controllers.enums.ResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {
    private ResponseStatus responseStatus;
    private Long bookingId;
    private int amount;
    // no need to send theatre and movie info, he is already on that page.
    // payment not done yet. only booking id made now.
    // after getting the bookingId, the payment will be done.


}
