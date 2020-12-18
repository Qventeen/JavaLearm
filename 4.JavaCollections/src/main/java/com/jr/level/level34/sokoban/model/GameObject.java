package com.jr.level.level34.sokoban.model;


import com.jr.level.level34.sokoban.utils.RManager;

public abstract class GameObject {
    public static final int FIELD_SELL_SIZE = Integer.parseInt(RManager.getResSettings().getString("cell.length"));
    protected Direction direction = Direction.NONE;

    private int x, y, width, height;

    public GameObject(int x, int y) {
        this(x, y, FIELD_SELL_SIZE, FIELD_SELL_SIZE);
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract GameElement getType();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection(){
     return direction;
    }
}
