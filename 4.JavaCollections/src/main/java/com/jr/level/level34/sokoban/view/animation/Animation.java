package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.model.GameObject;
import com.jr.level.level34.sokoban.utils.RManager;
import com.jr.level.level34.sokoban.view.graphic.GraphicGameObject;
import com.jr.level.level34.sokoban.view.texture.SubTexture;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Animation {
    private static int speed = Integer.parseInt(RManager.getPropSetting("speed"));

    private MoveStep moveStep;
    private Direction direction;
    private int baseX, baseY, baseW, baseH;


    private Direction lastDirection;
    private int stepX, stepY, stepW,stepH;

    public Animation(GameObject gameObject) {
        setMoveStep(gameObject);
        setStepPoint(gameObject);
    }

    public AnimGO nextAnimationStep(){
        nextStepPoint();
        SubTexture sub =  isMoved() ? moveStep.stop(): moveStep.nextStep(direction);
        return new AnimGO(stepX, stepY, stepW, stepH, sub);
    }

    public void setNextMove(GraphicGameObject.InnerGO nStep){
        baseX = nStep.x;
        baseY = nStep.y;
        baseW = nStep.w;
        baseH = nStep.h;
        lastDirection = direction;
        this.direction = nStep.direction;
    }

    public static class AnimGO {
        public int x, y, w, h;
        public SubTexture sub;

        public AnimGO(int x, int y, int w, int h, SubTexture sub) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.sub = sub;
        }
    }

    public boolean isMoved(){
        if(lastDirection != direction){
            lastDirection = direction;
            return false;
        }
        return baseX == stepX && baseY == stepY && baseH == stepH && baseW == stepW;
    }

    //TechMethods
    private void nextStepPoint(){
        switch(direction){
            case UP: stepY = max(stepY - speed, baseY); break;
            case DOWN: stepY = min(stepY + speed, baseY); break;
            case LEFT: stepX = max(stepX - speed, baseX) ; break;
            case RIGHT: stepX = min(stepX + speed, baseX); break;
        }
        if(stepW < baseW) stepW = min(stepW + speed, baseW);
        if(stepW > baseW) stepW = max(stepW - speed, baseW);
        if(stepH < baseH) stepH = min(stepH + speed, baseH);
        if(stepH > baseH) stepH = min(stepH + speed, baseH);
    }

    //Construct methods
    private void setMoveStep(GameObject go){
        switch(go.getType()){
            case BOX: moveStep = new BoxMoveStep(); break;
            case WALL: moveStep = new WallMoveStep(); break;
            case GROUND: moveStep = new GroundMoveStep(); break;
            case HOME: moveStep = new HomeMoveStep(); break;
            case PLAYER: moveStep = new PlayerMoveStep(); break;
        }
    }

    private void setStepPoint(GameObject gameObject){
        lastDirection = direction = gameObject.getDirection();
        stepX = baseX = gameObject.getX();
        stepY = baseY = gameObject.getY();
        stepW = baseW = gameObject.getWidth();
        stepH = baseH = gameObject.getHeight();
    }

}
