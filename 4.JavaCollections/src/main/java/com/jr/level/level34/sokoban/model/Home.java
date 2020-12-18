package com.jr.level.level34.sokoban.model;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
    }

    public Home(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public GameElement getType() {
        return GameElement.HOME;
    }
}
