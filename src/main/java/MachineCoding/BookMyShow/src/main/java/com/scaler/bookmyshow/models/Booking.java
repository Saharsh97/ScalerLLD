package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.models.enums.BookingStatus;
import com.scaler.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.*;
// devTools
// lombok
// config processor

// MySQL Drive
// JPA => Java Persistence API, Jakarta Persistence API.
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity // This class will be a table.
public class Booking extends BaseModel{

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    private Date bookedAt;

    @ManyToMany
    private List<ShowSeat> showSeats;

    @Enumerated(EnumType.ORDINAL)   // maintains the order.
    private BookingStatus bookingStatus;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    // give payment status message to user

    private int amount;
}


// show s1 seat 50
// ShowSeat  s150
// booking b3 cancelled
// Booking b1 cancelled
// booking b2 confirmed

// booking table
// id, createdAt, user_id, show_id, amount, booking_status
// 1, now(), jayakrishan,   30,      300,    1
// 1, now(), shiva,         30,      300,    1
// 1, now(), rajat,         30,      300,    1

// the way you store the data, that is upto you!
