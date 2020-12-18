package com.jr.level.level29.task2912;

public interface Logger {
    void inform(String message, int level);

    void setNext(Logger next);

    void info(String message);
}
