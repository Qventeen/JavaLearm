package com.jr.level.level29.task2909.human;

public class BloodGroup {
    private final int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static final BloodGroup first() {
        return new BloodGroup(1);
    }

    public static final BloodGroup second() {
        return new BloodGroup(2);
    }

    public static final BloodGroup third() {
        return new BloodGroup(3);
    }

    public static final BloodGroup fourth() {
        return new BloodGroup(4);
    }
}
