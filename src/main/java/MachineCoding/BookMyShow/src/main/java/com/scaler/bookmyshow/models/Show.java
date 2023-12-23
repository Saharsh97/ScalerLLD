package com.scaler.bookmyshow.models;

import com.scaler.bookmyshow.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity (name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Screen screen;

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}


// students and batches
// both are separate tables.

// batch
// batch_name, strength, dateOfCreation, student_ids

// student
// name, email, batch_id
// Saharsh, jkl, 1