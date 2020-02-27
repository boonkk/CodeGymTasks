package com.codegym.task.task26.task2613.command;

import com.codegym.task.task26.task2613.ConsoleHelper;
import com.codegym.task.task26.task2613.CurrencyManipulator;
import com.codegym.task.task26.task2613.CurrencyManipulatorFactory;
import com.codegym.task.task26.task2613.exception.InterruptedOperationException;

class InfoCommand implements Command {

    @Override
    public void execute() throws InterruptedOperationException {
        boolean money = false;

        for (CurrencyManipulator currency : CurrencyManipulatorFactory.getAllCurrencyManipulators())
            if (currency.hasMoney()) {
                if (currency.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(currency.getCurrencyCode() + " - " + currency.getTotalAmount());
                    money = true;
                }
            }

        if (!money)
            ConsoleHelper.writeMessage("No money available.");
    }
}
