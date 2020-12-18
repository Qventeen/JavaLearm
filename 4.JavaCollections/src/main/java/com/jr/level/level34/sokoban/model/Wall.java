package com.jr.level.level34.sokoban.model;

public class Wall extends GameObject{
    public Wall(int x, int y) {
        super(x, y);
    }


    @Override
    public GameElement getType() {
        return GameElement.WALL;
    }
}
