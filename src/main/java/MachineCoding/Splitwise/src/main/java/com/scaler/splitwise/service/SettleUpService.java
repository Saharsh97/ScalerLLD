package com.scaler.splitwise.service;

import com.scaler.splitwise.models.*;
import com.scaler.splitwise.repositories.ExpenseRepository;
import com.scaler.splitwise.repositories.GroupRepository;
import com.scaler.splitwise.repositories.UserExpenseRepository;
import com.scaler.splitwise.repositories.UserRepository;
import com.scaler.splitwise.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {

    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;
    private SettleUpStrategy settleUpStrategy;

    @Autowired
    public SettleUpService(GroupRepository groupRepository, ExpenseRepository expenseRepository, UserRepository userRepository, UserExpenseRepository userExpenseRepository, SettleUpStrategy settleUpStrategy){
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUpUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("group not found");
        }
        User user = optionalUser.get();

        // 1. get all the expenses related to the user
        // how to get this?? In Expense we cannot directly those corresponding to this user.
        // Expense has UserExpense list.
        List<UserExpense> userExpenseList = userExpenseRepository.findAllByUser(user);

        // need to extract List<Expense> and give to strategy
        Set<Expense> expenses = new HashSet<>();
        // expense1 : whoPaid has A : 1000
        // expense1 : whoHadToPay has A : 500
        // both will add the same expense, expense1 twice in the list.
        // so use set.
        for(UserExpense userExpense: userExpenseList){
            expenses.add(userExpense.getExpense());
            // any checks here?
            // expenses contains what type of expenses? REAL and SETTLE_UP_TRANSACTIONS
            // do we need both of them to calculate List of transactions? Yes!
        }

        // 2. iterate through all the expenses, to check who pays to whom
        // 3. generating transactions to settle up
        List<Transaction> settleUpTransactions = settleUpStrategy.settleUp(expenses.stream().toList());

        // 4. return transactions.
        return settleUpTransactions;
    }

    public List<Transaction> settleUpGroup(Long groupId){
        // get the group using groupId
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if(optionalGroup.isEmpty()){
            throw new RuntimeException("group not found");
        }
        Group group = optionalGroup.get();


        // 1. get all the expenses of the group
        List<Expense> expenses = expenseRepository.findAllByGroup(group);


        // 2. iterate through all the expenses, to check who pays to whom
        // 3. generating transactions to settle up
        List<Transaction> settleUpTransactions = settleUpStrategy.settleUp(expenses);

        // 4. return transactions.
        return settleUpTransactions;
    }
}