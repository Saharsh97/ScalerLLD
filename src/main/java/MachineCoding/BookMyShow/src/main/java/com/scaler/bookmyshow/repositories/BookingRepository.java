package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Booking;
import com.scaler.bookmyshow.models.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
