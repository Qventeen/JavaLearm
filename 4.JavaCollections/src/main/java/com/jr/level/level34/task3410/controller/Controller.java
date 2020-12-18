package com.jr.level.level34.task3410.controller;

import com.jr.level.level34.task3410.model.Model;
import com.jr.level.level34.task3410.view.View;

public class Controller {
    private Model model;
    private View view;


    public Controller() {
        model = new Model();
        view = new View(this);
    }

    public static void main(String[] args) {

    }
}
