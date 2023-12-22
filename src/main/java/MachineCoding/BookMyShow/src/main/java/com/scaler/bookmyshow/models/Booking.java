package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.models.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity // entity not a part of lombok. it is a part of jakarta persistence api
// @Entity tells that this has to be a part of the table.
// also need to mention what is supposed to be primary key.
// where is the id present.
public class Booking extends BaseModel{
    @Enumerated(EnumType.ORDINAL)   // enter the same order of enums in the table
    private BookingStatus bookingStatus;
    // find cardinality of Booking and showSeats. 1 booking has M showSeats. 1 showSeat has 1 booking only!
    // but I will also have cancelled bookings. 1 showSeat will have M Bookings.
    // Same showSeat will have a cancelled booking, and booked booking
    // B : S
    // 1 : M
    // M : 1
    // M : M
    @ManyToMany
    private List<ShowSeat> showSeats;

    // 1 booking has 1 User. 1 user has many bookings.
    @ManyToOne
    private User user;
    private Date bookedAt;

    @ManyToOne
    private Show show;
    private int amount;

    @OneToMany
    private List<Payment> payments;

}
