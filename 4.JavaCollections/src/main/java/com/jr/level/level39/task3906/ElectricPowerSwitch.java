package com.jr.level.level39.task3906;

public class ElectricPowerSwitch {
    private Switchable switchable;

    public ElectricPowerSwitch(Switchable switchable) {
        this.switchable = switchable;
    }

    public void press() {
        System.out.println("Power switch flipped.");
        if (switchable.isOn()) {
            switchable.turnOff();
        } else {
            switchable.turnOn();
        }
    }
}
