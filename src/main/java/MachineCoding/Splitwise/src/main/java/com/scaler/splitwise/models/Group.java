package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "userGroup")
// group is a reserved keyword
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> members;

    @OneToMany
    private List<Expense> expenses; // ideally it should have been groupId in expense table.
    // but here, a separate mapping is created.
    // create FK in only one table, not in both the tables (default behaviour)

    @ManyToOne
    private User createdBy;
}


// Group Expense
// 1        M
// 1        1