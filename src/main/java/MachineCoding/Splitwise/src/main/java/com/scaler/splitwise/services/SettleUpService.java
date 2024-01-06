package com.scaler.splitwise.services;

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
    private SettleUpStrategy settleUpStrategy;
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;

    @Autowired
    public SettleUpService(GroupRepository groupRepository, ExpenseRepository expenseRepository, SettleUpStrategy settleUpStrategy, UserRepository userRepository, UserExpenseRepository userExpenseRepository){
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
    }

    public List<Transaction> settleUpUser(Long userId){
        // 1. get the User object from the userId,
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("user not found");
        }
        User user = optionalUser.get();

        // 2. get all the UserExpense object, for this user.
        List<UserExpense> userExpenses = userExpenseRepository.findAllByUser(user);

        // 3. get the expense from the UserExpense objects.
        Set<Expense> expenses = new HashSet<>();
        for(UserExpense userExpense: userExpenses){
            expenses.add(userExpense.getExpense());
        }

        // 4. get the settleUpTransactions, given these expenses.
        List<Transaction> settleUpTransactions = settleUpStrategy.settleUp(expenses.stream().toList());

        // 5. from settleUpTransactions, get only those transactions,
        // in which this user is involved. settleUpUserTransactions
        List<Transaction> finalSettleUpTransactionForUser = new ArrayList<>();
        for(Transaction transaction: settleUpTransactions){
            if(transaction.getPayingUser() == user || transaction.getReceivingUser() == user){
                finalSettleUpTransactionForUser.add(transaction);
            }
        }

        // 6. return this settleUpUserTransactions.
        return finalSettleUpTransactionForUser;
    }


// R
// expense1 (individual): whoPaid: R = 500,
//               hadToPay: R = 200, J = 100, Sh = 200

// expense2 (group): whoPaid: R = 1000, Sh = 100
//                hadToPay: R = 500, J = 300, Sh = 700

// expense3 (individual): whoPaid: Sh = 500
//          hadToPay: R = 200, J = 300


// expense4 (group): whoPaid: J = 1000
//          hadToPay: J = 200, Sh = 300


    // run the strategy
// settleUpTransactions.
    // R -> Sh : 500
    // J -> R : 200
    // Sh -> J : 1000

//    final settleUpUserTransactions
    // R -> Sh : 500
    // J -> R : 200

    public List<Transaction> settleUpGroup(Long groupId){
        // 1. get the group object, from the groupId
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if(optionalGroup.isEmpty()){
            throw new RuntimeException("group not found");
        }
        Group group = optionalGroup.get();

        // 2. get all the expense.
        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        // 3. run the algorithm to get the list of settle up Transaction
        // there are 2 ways to get the settle up transactions.
        List<Transaction> settleUpTransactions = settleUpStrategy.settleUp(expenses);
        // 4. return the List<Transaction>

        return settleUpTransactions;
    }
}
