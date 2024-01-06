package com.scaler.splitwise;

import com.scaler.splitwise.commands.CommandExecutor;
import com.scaler.splitwise.commands.SettleUpGroupCommand;
import com.scaler.splitwise.commands.SettleUpUserCommand;
import com.scaler.splitwise.controllers.SettleUpController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner {

    private CommandExecutor commandExecutor;

    @Autowired
    private SettleUpController settleUpController;

    private Scanner sc = new Scanner(System.in);

    @Autowired
    public SplitwiseApplication(CommandExecutor commandExecutor){
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run(String... args) throws Exception {
        commandExecutor.addCommand(new SettleUpUserCommand(settleUpController));
        commandExecutor.addCommand(new SettleUpGroupCommand(settleUpController));

        while(true){
            String input = sc.next(); // input: SettleUpGroup groupId
            commandExecutor.execute(input);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }
}


// Agenda
// Implement
    // Models
    // Set up our codebase of settleUpUser
    // Commands

// HW
// register : UserController
// add user in group : GroupController
// add expense to group : ExpenseController

// settleUpUser : UserController X
// settleUpGroup : GroupController X
//                 SettleUpController
