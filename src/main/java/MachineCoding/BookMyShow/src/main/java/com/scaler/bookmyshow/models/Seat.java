package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String seatNumber;  // number as column in mysql.
    private SeatType seatType;
    private int rowValue;
    private int columnValue;
}

