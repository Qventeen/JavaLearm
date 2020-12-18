package com.jr.level.level34.sokoban.model;


public abstract class CollisionObject extends GameObject implements Movable {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public CollisionObject(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        int x = gameObject.getX();
        int y = gameObject.getY();

        switch (direction){
            case RIGHT: return getX() + FIELD_SELL_SIZE == x && getY() == y;
            case LEFT: return getX() - FIELD_SELL_SIZE == x && getY() == y;
            case UP: return getY() - FIELD_SELL_SIZE == y && getX() == x;
            case DOWN: return getY() + FIELD_SELL_SIZE == y && getX() == x;
            default: return false;
        }
    }

    @Override
    public void move(Direction direction) {
        switch (direction){
            case RIGHT: setX(getX() + FIELD_SELL_SIZE); break;
            case LEFT:  setX(getX() - FIELD_SELL_SIZE); break;
            case UP:  setY(getY() - FIELD_SELL_SIZE); break;
            case DOWN: setY(getY() + FIELD_SELL_SIZE); break;
        }
        setDirection(direction);
    }
}

