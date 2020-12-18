package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.utils.RManager;
import com.jr.level.level34.sokoban.view.texture.SubTexture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerMoveStep extends BaseMoveStep {
    private static final Map<Direction, List<SubTexture>> map = new HashMap<>();
    static{
        init();
    }
    private static void init(){
        map.put(Direction.UP, new ArrayList<>());
        map.put(Direction.DOWN, new ArrayList<>());
        map.put(Direction.LEFT, new ArrayList<>());
        map.put(Direction.RIGHT, new ArrayList<>());

        map.get(Direction.UP).add(RManager.getSubTexture(RManager.getPropPlayer("up")));
        map.get(Direction.UP).add(RManager.getSubTexture(RManager.getPropPlayer("up.rstep")));
        map.get(Direction.UP).add(RManager.getSubTexture(RManager.getPropPlayer("up.lstep")));

        map.get(Direction.DOWN).add(RManager.getSubTexture(RManager.getPropPlayer("down")));
        map.get(Direction.DOWN).add(RManager.getSubTexture(RManager.getPropPlayer("down.lstep")));
        map.get(Direction.DOWN).add(RManager.getSubTexture(RManager.getPropPlayer("down.rstep")));

        map.get(Direction.LEFT).add(RManager.getSubTexture(RManager.getPropPlayer("left")));
        map.get(Direction.LEFT).add(RManager.getSubTexture(RManager.getPropPlayer("left.step")));

        map.get(Direction.RIGHT).add(RManager.getSubTexture(RManager.getPropPlayer("right")));
        map.get(Direction.RIGHT).add(RManager.getSubTexture(RManager.getPropPlayer("right.step")));
    }

    private Direction lastDirection = Direction.DOWN;
    private int currentIndex = 0;

    @Override
    public SubTexture nextStep(Direction direction) {
        direction = direction == Direction.NONE? Direction.DOWN : direction;
        if(lastDirection != direction) {
            currentIndex = 0;
        }

        List<SubTexture> list = map.get(direction);
        lastDirection = direction;

        currentIndex = ++currentIndex % list.size();
        SubTexture result = list.get(currentIndex);

        return result;
    }

    @Override
    public SubTexture stop() {
        currentIndex = 0;
        return map.get(lastDirection).get(currentIndex);
    }
}
