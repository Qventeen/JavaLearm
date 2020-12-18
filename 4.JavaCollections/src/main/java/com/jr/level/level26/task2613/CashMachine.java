package com.jr.level.level26.task2613;

import com.jr.level.level26.task2613.command.CommandExecutor;
import com.jr.level.level26.task2613.exception.InterruptOperationException;
import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Operation operation;
        try {
            CommandExecutor.execute(Operation.LOGIN);
            do{
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while(operation != Operation.EXIT);
        } catch (InterruptOperationException exception) {
            ConsoleHelper.printExitMessage();
        }
    }
}
