package com.jr.level.level31.task3110.command;

import com.jr.level.level31.task3110.ConsoleHelper;

public class ExitCommand implements Command {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("До встречи!");
    }
}
