package com.jr.level.level34.sokoban.model;

import com.jr.level.level34.sokoban.controller.EventListener;
import com.jr.level.level34.sokoban.utils.RManager;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Model  {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private Map<Box, Home> boxInHome = new HashMap<>();

    private int currentLevel = 1;
    private LevelLoader levelLoader;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public Model() {
        try {
            levelLoader = new LevelLoader(Paths.get(
                    getClass().getResource(RManager.getResGame().getString("levels")).toURI()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        restart();
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level){
        if(level < 1 ) return;
        gameObjects = levelLoader.getLevel(level);
        currentLevel = level;
        boxInHome.clear();
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel(){
        currentLevel++;
        restartLevel(currentLevel);
    }

    public void move(Direction direction) {
        if(checkLevelComplete()){
            eventListener.levelCompleted(currentLevel);
        }

        Player player = gameObjects.getPlayer();
        player.setDirection(direction);
        if(checkWallCollision(player, direction)) return;
        if(checkBoxCollision(player, direction)) return;

        Box box = getCollisionBox(player, direction);
        if(box != null) {
            box.move(direction);
            handleBoxInHome(box);
        }
        player.move(direction);
    }

    //Check collisions
    private boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for(Wall wall: gameObjects.getWalls()){
            if(gameObject.isCollision(wall, direction)){
                return true;
            }
        }
        return false;
    }

    private boolean checkBoxCollision(CollisionObject gameObject, Direction direction){
        Box cBox = getCollisionBox(gameObject, direction);
        if (cBox != null) {
            if (checkWallCollision(cBox, direction) || getCollisionBox(cBox, direction) != null) {
                return true;
            }
        }
        return false;
    }

    private Box getCollisionBox(CollisionObject gameObject, Direction direction){
        for(Box box: gameObjects.getBoxes()){
            if(box == gameObject) continue;
            if(gameObject.isCollision(box, direction)){
                return box;
            }
        }
        return null;
    }

    //Box at home handle
    private void handleBoxInHome(Box box){
        Home oldHome = boxInHome.get(box);
        Home newHome = getHomeForBox(box);

        if(oldHome != newHome) {
            setScaleObject(newHome, 1.75);
            setScaleObject(oldHome, 1/1.75);

            if(oldHome!=null) setScaleObject(box, 2);
            if(newHome!=null) setScaleObject(box, 0.5);

            boxInHome.put(box, newHome);
        }
    }

    private Home getHomeForBox(Box box){
        for(Home home: gameObjects.getHomes()){
            if(box.getX() == home.getX() && box.getY() == home.getY()){
                return home;
            }
        }
        return null;
    }

    private void setScaleObject(GameObject go, double factor){
        if(go == null) return;
        go.setHeight((int) (go.getHeight() * factor));
        go.setWidth((int) (go.getWidth() * factor));
    }

    //Level complete test
    private boolean checkLevelComplete(){
        boolean result = false;
        for(Box box: gameObjects.getBoxes()){
            for(Home home: gameObjects.getHomes()){
                if(box.getX() == home.getX() && box.getY() == home.getY()){
                    result = true;
                    break;
                }
            }

            if(!result) return false;
            result = false;
        }
        return true;
    }


    public static void main(String[] args) {
        Model model = new Model();
        System.out.println(model.checkBoxCollision(model.getGameObjects().getPlayer(), Direction.LEFT));
    }
}
