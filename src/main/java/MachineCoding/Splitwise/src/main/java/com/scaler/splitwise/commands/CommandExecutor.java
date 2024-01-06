package com.scaler.splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commands;

    public CommandExecutor(){
        commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        // input: SettleUpGroup groupId
        for(Command command: commands){
            if(command.matches(input)){
                command.execute(input);
                return;
            }
        }
        throw new RuntimeException("given input is wrong");
    }
}
