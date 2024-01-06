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

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members;

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

}

// ideally it should have been groupId in expense table.
// but here, my use-case is
// from group, I wanted to get expenses. so mapping table.
// no need for expense table having groupId.
// so no column of groupId in expense table
// create FK in only one table, not in both the tables (default behaviour)

// G:E
// 1:M, id of group, on the Expense table

// I want, first I get the group.
// from the group, I get the expense.

// to get all the expense: find All by groupId
// mapping table
// group_id, expense_id
// 1            1
// 1            2
// 1            3
// 4            10
// 4            11

// Group Expense
// 1        M
// 1        1