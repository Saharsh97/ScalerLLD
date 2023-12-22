package com.scaler.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.Date;

@Getter
@Setter
// annotations uses a decorator. annotations are case sensitive
// annotations enforce the behaviour, indicates this behaviour is present!
//@NoArgsConstructor
//@AllArgsConstructor

// no @Entity here, I dont want a separate table of BaseModel.
// how inheritance is represented in table.
// what was the better way? keep common attr. in one table, have specific attr. in another table.

// have to tell, all these attributes will be a part of all the models
@MappedSuperclass
// this is different than pen example. we want all the attributes of BaseModel as a part of all the models.

// if we dont have a base class, we will have to specify @Id in every model
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // auto increment
    private Long id;
    private Date createdAt;
    private Date modifiedAt;
}
