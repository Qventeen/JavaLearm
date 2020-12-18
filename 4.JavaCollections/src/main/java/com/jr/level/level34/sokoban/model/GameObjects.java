package com.jr.level.level34.sokoban.model;

import java.util.HashSet;
import java.util.Set;

public class GameObjects {
    private int width;
    private int height;
    private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Player player;
    private Ground ground = new Ground(0,0);

    public GameObjects(int width, int height) {
        assert width > 0 && height > 0;

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Set<Wall> getWalls() {
        return walls;
    }

    public void setWalls(Set<Wall> walls) {
        this.walls = walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(Set<Box> boxes) {
        this.boxes = boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public void setHomes(Set<Home> homes) {
        this.homes = homes;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Set<GameObject> getAll(){
        Set<GameObject> gameObjects = new HashSet<>();
        gameObjects.addAll(boxes);
        gameObjects.addAll(walls);
        gameObjects.addAll(homes);
        gameObjects.add(player);
        return gameObjects;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }
}
