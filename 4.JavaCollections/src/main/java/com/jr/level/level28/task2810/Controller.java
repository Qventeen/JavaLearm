package com.jr.level.level28.task2810;

import com.jr.level.level28.task2810.model.Model;

public class Controller {
    private Model model;

    public Controller(Model model) {
        if (model == null) throw new IllegalArgumentException();
        this.model = model;
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }
}
