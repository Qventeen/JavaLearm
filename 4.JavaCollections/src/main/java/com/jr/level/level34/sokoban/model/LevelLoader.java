package com.jr.level.level34.sokoban.model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.jr.level.level34.sokoban.model.GameObject.FIELD_SELL_SIZE;

public class LevelLoader {
    private final int LINE = FIELD_SELL_SIZE;
    private Path levels;
    private Map<Integer, LevelMetaInfo> levelMetaData = new HashMap<>();

    public LevelLoader(Path levels) {
        this.levels = levels;
        readMetaData();
    }

    public GameObjects getLevel(int level){
        int line = LINE / 2;

        Player player = null;
        Ground ground = new Ground(0, 0);
        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();

        level = Math.abs(level) % (levelMetaData.size() + 1);
        LevelMetaInfo li = levelMetaData.get(level);

        try(RandomAccessFile raf = new RandomAccessFile(levels.toFile(), "r")) {
            raf.readLine();
            raf.seek(li.startPos);
            for(int y = 0; y < li.h; y++){
                String str = raf.readLine();
                for(int x = 0; x < str.length(); x++){
                    switch(str.charAt(x)) {
                        case 'X': walls.add(new Wall(x * FIELD_SELL_SIZE + LINE,y * FIELD_SELL_SIZE + LINE)); break;
                        case '.': homes.add(new Home(x * FIELD_SELL_SIZE + LINE,y * FIELD_SELL_SIZE + LINE, FIELD_SELL_SIZE / 2, FIELD_SELL_SIZE / 2)); break;
                        case '*': boxes.add(new Box(x * FIELD_SELL_SIZE + LINE,y * FIELD_SELL_SIZE + LINE)); break;
                        case '@': player = new Player(x * FIELD_SELL_SIZE + LINE,y * FIELD_SELL_SIZE + LINE); break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameObjects gameObjects = new GameObjects(li.w * FIELD_SELL_SIZE + FIELD_SELL_SIZE, li.h * FIELD_SELL_SIZE + LINE + FIELD_SELL_SIZE);
        gameObjects.setGround(ground);
        gameObjects.setPlayer(player);
        gameObjects.setWalls(walls);
        gameObjects.setBoxes(boxes);
        gameObjects.setHomes(homes);

        return gameObjects;
    }

    private void readMetaData(){
        try(RandomAccessFile raf = new RandomAccessFile(levels.toFile(), "r")){
            String line;
            while((line = raf.readLine()) != null){
                if(line.startsWith("Maze: ")){
                    LevelMetaInfo li = new LevelMetaInfo();
                    li.levelN = Integer.valueOf(line.substring(6));

                    raf.readLine();
                    li.w = Integer.parseInt(raf.readLine().substring(8));
                    li.h = Integer.parseInt(raf.readLine().substring(8));

                    raf.readLine();
                    raf.readLine();
                    raf.readLine();
                    li.startPos = raf.getFilePointer();

                    levelMetaData.put(li.levelN, li);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class LevelMetaInfo{
        Integer levelN;
        int w;
        int h;
        long startPos;
    }

}
