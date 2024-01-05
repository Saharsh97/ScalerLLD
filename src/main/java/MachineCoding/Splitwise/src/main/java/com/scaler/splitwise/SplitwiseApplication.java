package com.scaler.splitwise;

import com.scaler.splitwise.commands.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

    CommandExecutor commandExecutor;
    Scanner sc = new Scanner(System.in);

    @Autowired
    public SplitwiseApplication(CommandExecutor commandExecutor){
        this.commandExecutor = commandExecutor;
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
            String input = sc.next();
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
// Heap Algorithm
// completing the controller flow, and make the controller work.
// register
// add user in group
// add expense to group


// /settleUp: Associated to User. Will the User model be really affected?
// /settleUpGroup: Associated to Group. same here.
// so we have settleUpController
