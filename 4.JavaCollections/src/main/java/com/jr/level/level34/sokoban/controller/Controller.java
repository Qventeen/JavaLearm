package com.jr.level.level34.sokoban.controller;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.model.GameObjects;
import com.jr.level.level34.sokoban.model.Model;
import com.jr.level.level34.sokoban.view.View;

public class Controller implements EventListener {
    private Model model;
    private View view;


    public Controller() {
        model = new Model();
        model.restart();
        model.setEventListener(this);
        view = View.newInstance(this);
        view.setEventListener(this);

    }

    public static void main(String[] args)  {
        Controller controller = new Controller();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void selectLevel(int level) {
        model.restartLevel(level);
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.levelCompleted(level);
    }

    public GameObjects getGameObjects(){
        return model.getGameObjects();
    }
}
