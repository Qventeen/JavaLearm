package com.jr.level.level34.sokoban.model;


public class Box extends CollisionObject {

    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public GameElement getType() {
        return GameElement.BOX;
    }

}
