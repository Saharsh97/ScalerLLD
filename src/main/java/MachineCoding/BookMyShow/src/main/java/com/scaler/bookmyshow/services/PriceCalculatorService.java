package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.models.SeatType;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import com.scaler.bookmyshow.models.ShowSeatType;
import com.scaler.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        // 1. given the show, get the seatTypes, and their corresponding price.
        List<ShowSeatType> dbShowSeatTypes = showSeatTypeRepository.findAllByShow(show);

        // 2.
        int amount = 0;
        for(ShowSeat selectedShowSeat : showSeats){
            SeatType selectedSeatType = selectedShowSeat.getSeat().getSeatType();
            for(ShowSeatType dbShowSeatType : dbShowSeatTypes){
                if(dbShowSeatType.getSeatType() == selectedSeatType){
                    amount += dbShowSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}

// user selection of ShowSeats.
// Animal23 A1  GOLD
// Animal23 A2  GOLD
// Animal23 A3  GOLD
// Animal23 B1  PLATINUM

// in DB: show_seat_type Table
// show_id,     seat_type,  price
// animal23,    SILVER,     150
// animal23,    GOLD,       200
// animal23,    PLATINUM,   300

