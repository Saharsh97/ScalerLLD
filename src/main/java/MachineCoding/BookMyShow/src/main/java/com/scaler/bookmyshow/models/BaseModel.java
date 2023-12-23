package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

@MappedSuperclass   // this class is the super-class of the corresponding tables
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment.!
    private Long id;
    private Date createdAt;
    private Date modifiedAt;
}


// BaseModel is a superclass.
// Booking, Payment, User, Show these are sub-classes
// sub-classes are the tables.

// MappedSuperclass -> My superclass attributes, will be
// the columns in sub-class tables.
