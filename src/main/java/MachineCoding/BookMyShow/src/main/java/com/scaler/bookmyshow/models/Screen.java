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

    // This is a list of enums. This will be stored as a mapping table.
    // find cardinality: it will be M : M.
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // whenever you want to generate mapping table for this enum,
    // tables created: screens_features.
    private List<Feature> features;
}
