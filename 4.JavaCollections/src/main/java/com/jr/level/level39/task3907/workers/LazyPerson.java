package com.jr.level.level39.task3907.workers;

public class LazyPerson implements Sleeper, Eater {

    @Override
    public void eat() {
        System.out.println("LazyPerson is eating!");
    }

    @Override
    public void sleep() {
        System.out.println("LazyPerson is sleeping!");
    }
}
