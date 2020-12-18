package com.jr.level.level34.sokoban.model;

public class Ground extends GameObject {

    public Ground(int x, int y) {
        super(x, y);
    }

    @Override
    public GameElement getType() {
        return GameElement.GROUND;
    }
}
