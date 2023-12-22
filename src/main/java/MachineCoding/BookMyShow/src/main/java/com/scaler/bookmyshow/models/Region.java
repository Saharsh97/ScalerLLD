package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Region extends BaseModel{
    private String name;

    // 1 : M
    // 1 : 1
    // 1 : M
    @OneToMany
    private List<Theatre> theatres;
}
