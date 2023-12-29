package com.scaler.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter

@EntityListeners(AuditingEntityListener.class)
// whatever table updates are happening by the spring app
// JpaAuditing is creating audit events.
// I will listen that info here.
// from that info, I want to update the createAt and lastModifiedAt over here.
@MappedSuperclass   // this class is the super-class of the corresponding tables
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment.!
    private Long id;

    // as a part of JpaAuditing
    @CreatedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date modifiedAt;
}


// BaseModel is a superclass.
// Booking, Payment, User, Show these are sub-classes
// sub-classes are the tables.

// MappedSuperclass -> My superclass attributes, will be
// the columns in sub-class tables.
