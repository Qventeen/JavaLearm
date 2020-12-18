package com.jr.level.level34.sokoban.controller;

import com.jr.level.level34.sokoban.model.Direction;

public interface EventListener {
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void selectLevel(int level);
    void levelCompleted(int level);
}
