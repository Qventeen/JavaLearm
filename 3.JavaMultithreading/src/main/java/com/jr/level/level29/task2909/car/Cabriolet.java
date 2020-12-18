package com.jr.level.level29.task2909.car;

public class Cabriolet extends Car {
    private final int MAX_CABRIOLET_SPEED = 90;
    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET,numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
