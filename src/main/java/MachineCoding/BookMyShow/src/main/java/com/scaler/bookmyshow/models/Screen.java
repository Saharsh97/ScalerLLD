package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    @ElementCollection  // to store list of enums.
    private List<Feature> features;
}

// parking lot, and List<allowedVehicleType>


// screen_features
// screen_id    | feature_id
// s1           | 5
// s1           | 1
// s1           | 4
// s2           | 1
// s2           | 3
