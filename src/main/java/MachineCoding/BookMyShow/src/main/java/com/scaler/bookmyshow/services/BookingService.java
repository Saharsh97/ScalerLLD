package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.controllers.BookingController;
import com.scaler.bookmyshow.exceptions.ShowSeatUnavailableException;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.models.enums.BookingStatus;
import com.scaler.bookmyshow.models.enums.ShowSeatStatus;
import com.scaler.bookmyshow.repositories.BookingRepository;
import com.scaler.bookmyshow.repositories.ShowRepository;
import com.scaler.bookmyshow.repositories.ShowSeatRepository;
import com.scaler.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    // need something for all the DB dependency here. Repository.
    @Autowired
    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculatorService){
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, List<Long> showSeatIds, Long showId) throws ShowSeatUnavailableException {
        // steps, pseudo code:
        // 1. get the user by userId.
        // 2. get show with the showId.
        // ------ Take a lock on the showSeatIds -------- (start transaction)
        // 3. get the showSeats using showSeatIds
        // 4. check if all the showSeats are available.
        // 5. if any not available, throw error.
        // 6. now all available, Mark all the selected seats as BLOCKED.
        // 7. after Marking them, save these showSeatIds as BLOCKED and save to DB.
        // ------ release the lock -------- (end transaction)
        // 8. create the corresponding booking object.
        // 9. save the Booking details to DB.
        // 10. return the Booking object


        // here it is required to take a lock at a particular point in code.
        // and release the lock at a particular point in code.
        // This will be covered in detail in the Project Module.
        // for now, We will take a lock on this entire method. Not Much difference.


        // @Transaction(isolation = Isolation.SERIALIZABLE) (Spring framework)
        // transaction starts when this method is started.
        // transaction ends when this method ends.


        // 1. find user by userId;
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new RuntimeException("No user found");    // throw your own defined excpetions.
        }
        User bookedBy = userOptional.get();


        // 2. get show with the showId.
        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw new RuntimeException("show not found");
        }
        Show bookedShow = showOptional.get();


        // 3. get the showSeats using showSeatIds
        // why not optional here? the list will be empty if invalid ids
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);


        // 4. check if all the showSeats are available.
        // 5. if any not available, throw error.
        for(ShowSeat showSeat: showSeats){
//            if(showSeat.getStatus() != ShowSeatStatus.AVAILABLE)
            if(showSeat.getStatus() == ShowSeatStatus.BOOKED ||
                    (showSeat.getStatus() == ShowSeatStatus.BLOCKED && (Duration.between(new Date().toInstant(), showSeat.getLockedAt().toInstant()).toMinutes() < 15))){   // not just check on Available.
                // should check Blocked, and lock timings.
                // add lockedAt in ShowSeat
                throw new ShowSeatUnavailableException("Selected seats not available for given show");
            }
        }

        // 6. now all available, Mark all the selected seats as BLOCKED.
        for(ShowSeat showSeat: showSeats){
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
        }


        // 7. after Marking them, save these showSeatIds as BLOCKED and save to DB.
        List<ShowSeat> savedShowSeats = showSeatRepository.saveAll(showSeats);  // this will contain the updated showSeats.


        // 8. new Booking, add status PENDING, neither confirmed, nor cancelled
        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(savedShowSeats);
        booking.setUser(bookedBy);
        booking.setBookedAt(new Date());
        booking.setShow(bookedShow);
//        booking.setAmount(0);   // todo another service for amount.
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, bookedShow));
        // services can talk internally amongst themselves.
        booking.setPayments(new ArrayList<>());     // todo

        // we have to return booking Id in the response DTO of controller.
        // this id will be generated by the database.
        // 9. save Booking to DB.
        Booking savedBooking = bookingRepository.save(booking);

        // booking id will be returned.
        // then separate call for summary, based on booking id
        // then separate call for payment.
        return savedBooking;
    }
}
