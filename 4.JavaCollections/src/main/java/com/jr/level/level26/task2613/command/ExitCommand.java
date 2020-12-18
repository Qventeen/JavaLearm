package com.jr.level.level26.task2613.command;

import com.jr.level.level26.task2613.ConsoleHelper;
import com.jr.level.level26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.jr.level.level26.task2613.CashMachine.RESOURCE_PATH;

class ExitCommand implements Command {
    private final ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "exit");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        if("y".equals(ConsoleHelper.readString().toLowerCase())){
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }

    }
}
