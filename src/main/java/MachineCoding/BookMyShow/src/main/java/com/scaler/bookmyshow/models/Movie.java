package com.scaler.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private String description;
}
