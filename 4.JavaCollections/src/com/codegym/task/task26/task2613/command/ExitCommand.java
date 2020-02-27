package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

class ExitCommand implements Command {


    @Override
    public void execute() throws InterruptedOperationException
    {
        ConsoleHelper.writeMessage("Are you sure want to quit? (y,n):");
        try {
            String s = ConsoleHelper.readString();
            if (s.equalsIgnoreCase("Y")) {
                ConsoleHelper.writeMessage("Bye");

            }
        } catch (InterruptedOperationException e) {
            throw new InterruptedOperationException (){};
        }
    }
}

