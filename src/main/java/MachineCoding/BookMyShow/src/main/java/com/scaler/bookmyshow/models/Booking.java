package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.models.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    private User user;
    private Show show;
    private Date bookedAt;
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;
    private List<Payment> payments;
    private int amount;
}
