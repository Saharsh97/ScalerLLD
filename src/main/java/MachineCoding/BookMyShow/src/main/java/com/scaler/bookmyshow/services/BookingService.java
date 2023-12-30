package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.controllers.BookingController;
import com.scaler.bookmyshow.exceptions.ShowSeatNotAvailableException;
import com.scaler.bookmyshow.exceptions.UserNotFoundException;
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

import java.awt.print.Book;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;
    private PriceCalculatorService priceCalculatorService;

    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository, PriceCalculatorService priceCalculatorService){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowSeatNotAvailableException {
        // -------- start transaction (take a soft lock) ----------

        // 1. get the user from the userID
        // 2. get the show from the showId
        // 3. get the ShowSeat object, from the showSeatIds
        // 4. check if the ShowSeats are available = AVAILABLE, or BLOCKED after 15mins
        // 5. if any ShowSeat is not available, throw an error
        // 6. update the status to BLOCKED. update the lockedAt time.
        // 7. save the ShowSeats to the DB.

        // 8. create the Booking object.
        // 9. return the Booking object to the controller.

        // --------- end transaction (release the lock) -------


        // 1. get the user
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user not found in DB");
        }
        User bookedBy = optionalUser.get();

        // 2. get the show
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new RuntimeException("show not found");
        }
        Show bookedShow = optionalShow.get();

        // 3. get the show seat objects
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        // 4. check if the ShowSeats are available = AVAILABLE, or BLOCKED after 15mins
        for(ShowSeat showSeat: showSeats){
            Date lockedAt = showSeat.getLockedAt();
            ShowSeatStatus status = showSeat.getStatus();
            if(status == ShowSeatStatus.BOOKED ||
                    (status == ShowSeatStatus.BLOCKED && Duration.between(new Date().toInstant(), lockedAt.toInstant()).toMinutes() < 15)){
                throw new ShowSeatNotAvailableException("seat not available");
            }
        }

        // 5. update the status of Available seats
        for(ShowSeat showSeat: showSeats){
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeat.setLockedAt(new Date());
        }

        // 6. save to db
        List<ShowSeat> savedShowSeats = showSeatRepository.saveAll(showSeats);


        //
        Booking booking = new Booking();
        booking.setUser(bookedBy);
        booking.setShow(bookedShow);
        booking.setBookedAt(new Date());
        booking.setShowSeats(savedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculatorService.calculatePrice(savedShowSeats, bookedShow));   // we have to calculate today
        booking.setPayments(new ArrayList<>());

        //
        Booking savedBooking = bookingRepository.save(booking);

        return savedBooking;
    }
}
