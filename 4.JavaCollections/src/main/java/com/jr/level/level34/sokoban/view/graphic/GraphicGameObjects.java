package com.jr.level.level34.sokoban.view.graphic;

import com.jr.level.level34.sokoban.model.GameObject;
import com.jr.level.level34.sokoban.model.GameObjects;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Collection of GraphicGameObjects
 */
public class GraphicGameObjects {
    private final GraphicGameObject ground;
    private final GraphicGameObject player;
    private final Set<GraphicGameObject> boxes;
    private final Set<GraphicGameObject> walls;
    private final Set<GraphicGameObject> homes;
    private final Set<GraphicGameObject> all;

    public Set<GraphicGameObject> getBoxes() {
        return boxes;
    }

    public Set<GraphicGameObject> getWalls() {
        return walls;
    }

    public Set<GraphicGameObject> getHomes() {
        return homes;
    }

    public GraphicGameObjects(GameObjects gameObjects) {
        ground = new GraphicGameObject(gameObjects.getGround());
        player = new GraphicGameObject(gameObjects.getPlayer());
        boxes = fromCollection(gameObjects.getBoxes());
        walls = fromCollection(gameObjects.getWalls());
        homes = fromCollection(gameObjects.getHomes());

        all = new HashSet<>();
        all.addAll(homes);
        all.addAll(walls);
        all.addAll(boxes);
        all.add(player);
    }

    public GraphicGameObject getGround() {
        return ground;
    }

    public GraphicGameObject getPlayer() {
        return player;
    }

    public Set<GraphicGameObject> getAll(){
        return all;
    }

    private Set<GraphicGameObject> fromCollection(Collection<? extends GameObject> elements){
        return elements.stream().map(GraphicGameObject::new).collect(Collectors.toSet());
    }

    public void update() {
        player.update();
        boxes.forEach(GraphicGameObject::update);
        homes.forEach(GraphicGameObject::update);
    }

    public boolean isMoved() {
        boolean result = true;
        if(!player.isMoved()) {
            result = false;
        }
        else{
            for(GraphicGameObject go: boxes){
                if(!go.isMoved()){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
