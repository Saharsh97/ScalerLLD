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
        // does ShowSeat have the price? no, ShowSeatType has the price.
        // price stored in DB only.

        // 1. get seatStypes for the given show.
        // 2. I know seatType and its price for this show.
        // get the price of each of the seats given in ShowSeat.
        // 3. Then get the amount.

        // create ShowSeatTypeRepository.
        // find all ShowSeatTypes, given a show id.
        List<ShowSeatType> dbShowSeatTypes = showSeatTypeRepository.findAllByShow(show);

        int amount = 0;
        for(ShowSeat selectedShowSeat: showSeats){
            SeatType selectedSeatType = selectedShowSeat.getSeat().getSeatType();
            ShowSeatType dbShowSeatType = dbShowSeatTypes.stream().filter(x -> x.getSeatType().equals(selectedSeatType)).findFirst().get();
            amount += dbShowSeatType.getPrice();
        }
        // now add the PriceCalculatorService to the BookingService.
        return amount;
    }
}

// Animal23 A1  GOLD
// Animal23 A2  GOLD
// Animal23 A3  GOLD
// Animal23 B1  PLATINUM

// in DB:
// show_id,     seat_type,  price
// animal23,    SILVER,     150
// animal23,    GOLD,       200
// animal23,    PLATINUM,   300

//