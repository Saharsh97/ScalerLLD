package com.scaler.bookmyshow.controllers.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDTO {
    private List<Long> showSeatIds; // explain, how showSeatsIds here (ipad)
    private Long userId;
    private Long showId;
}
