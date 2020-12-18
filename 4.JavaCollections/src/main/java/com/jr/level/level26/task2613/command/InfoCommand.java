package com.jr.level.level26.task2613.command;

import com.jr.level.level26.task2613.ConsoleHelper;
import com.jr.level.level26.task2613.CurrencyManipulator;
import com.jr.level.level26.task2613.CurrencyManipulatorFactory;
import java.util.ResourceBundle;

import static com.jr.level.level26.task2613.CashMachine.RESOURCE_PATH;

class InfoCommand implements Command {
    private static final String CURRENCY_FORMAT = "%s - %s";
    private final ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "info");

    @Override
    public void execute() {
        boolean hasMoney = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for(CurrencyManipulator manipulator: CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if(manipulator.hasMoney()){
                ConsoleHelper.writeMessage(String.format(
                        CURRENCY_FORMAT,
                        manipulator.getCurrencyCode(),
                        manipulator.getTotalAmount()
                ));
                hasMoney = true;
            }
        }
        if(!hasMoney){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
