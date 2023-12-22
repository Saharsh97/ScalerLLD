package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.models.enums.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    // draw table example in ipad if needed
    // 1 showseat has 1 show.
    // 1 particular show can be present in how many showseat objects. Many, due to many seats.
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus status;
}
