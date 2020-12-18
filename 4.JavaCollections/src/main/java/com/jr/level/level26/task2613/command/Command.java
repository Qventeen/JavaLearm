package com.jr.level.level26.task2613.command;

import com.jr.level.level26.task2613.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException;
}
