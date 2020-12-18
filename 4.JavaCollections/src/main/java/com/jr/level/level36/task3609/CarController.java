package com.jr.level.level36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void increaseSpeed(int seconds) {
        int speed = model.getSpeed();
        int maxSpeed = model.getMaxSpeed();
        if (speed < maxSpeed) {
            speed += (3.5 * seconds);
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
        setCarSpeed(speed);
    }

    public void decreaseSpeed(int seconds) {
        int speed = getCarSpeed();
        if (speed > 0) {
            speed -= (12 * seconds);
        }
        if (speed < 0) {
            speed = 0;
        }
        setCarSpeed(speed);
    }



    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }
}
