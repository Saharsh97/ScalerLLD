package com.scaler.splitwise.services;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.models.Transaction;
import com.scaler.splitwise.repositories.ExpenseRepository;
import com.scaler.splitwise.repositories.GroupRepository;
import com.scaler.splitwise.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private SettleUpStrategy settleUpStrategy;

    public SettleUpService(GroupRepository groupRepository, ExpenseRepository expenseRepository, SettleUpStrategy settleUpStrategy){
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUpUser(Long userId){
        // 1. get the User object from the userId,
        // 2. get all the UserExpense object, for this user.
        // 3. get the expense from the UserExpense objects.
        // 4. get the settleUpTransactions, given these expenses.
        // 5. from settleUpTransactions, get only those transactions,
        // in which this user is involved. settleUpUserTransactions
        // 6. return this settleUpUserTransactions.
        return null;
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
