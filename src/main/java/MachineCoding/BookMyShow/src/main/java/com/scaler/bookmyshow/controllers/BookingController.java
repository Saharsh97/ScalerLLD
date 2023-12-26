package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.controllers.dto.BookMovieRequestDTO;
import com.scaler.bookmyshow.controllers.dto.BookMovieResponseDTO;
import com.scaler.bookmyshow.controllers.enums.ResponseStatus;
import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    // Spring framework knows what is MVC Architecture.
    // it has been made so, with MVC architecture in mind.
    // Spring Boot Framework has special tags, for @Controller, @Service, @Repository
    // define @Controller here.
    // It will identify these tags, and create the objects, for each level of dependency.
    // it will resolve the dependencies by itself.
    // these tag object stored in registry.

    // previously our main function was injecting this.
    // now we want the Spring to inject this, I wont write the main function.
    // so we use Autowired.
    // Autowired: Automatically find the object in params, create it if not already created.
    // And Pass it here.
    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    // 1. return type and the parameters? DTOs
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO requestDTO){
        // 2. which model will I check here? that I should get parameters from client.
        // I will return a booking object. so what parameters should I get from user, and what should I return.
        // ShowSeat will be given by the client. client gives this show, and these seats
        // client decides the show and his seats.

        // 3. conversation with whom? BookingService.

        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();
        try{
            Booking booking = bookingService.bookMovie(requestDTO.getUserId(), requestDTO.getShowSeatIds(), requestDTO.getShowId());

            responseDTO.setBookingId(booking.getId());
            responseDTO.setAmount(booking.getAmount());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
