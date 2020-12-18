package com.jr.level.level34.sokoban.model;

public class Player extends CollisionObject {

    public Player(int x, int y) {
        super(x, y);
        setWidth((int) (FIELD_SELL_SIZE / 1.5));
    }

    @Override
    public GameElement getType() {
        return GameElement.PLAYER;
    }

}
