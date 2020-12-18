package com.jr.level.level34.sokoban.view.graphic;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.model.GameElement;
import com.jr.level.level34.sokoban.model.GameObject;
import com.jr.level.level34.sokoban.view.animation.Animation;
import com.jr.level.level34.sokoban.view.texture.Texture;
import java.util.LinkedList;
import java.util.Queue;


public class GraphicGameObject {
    private final Queue<InnerGO> nextStep = new LinkedList<>();
    private final Animation animation;

    /**
     * Reference ob updatable element
     */
    private final GameObject baseGObject;

    public GraphicGameObject(GameObject gObject) {
        baseGObject = gObject;
        animation = new Animation(gObject);
    }

    public boolean isMoved(){
        return nextStep.size() == 0 && animation.isMoved();
    }

    public void draw(GraphicBackend graphic, Texture baseImage, int maxWidth, int maxHeight){
        if(animation.isMoved() && !nextStep.isEmpty()) {
            InnerGO nStep = nextStep.poll();
            animation.setNextMove(nStep);
        }

        Animation.AnimGO anim = animation.nextAnimationStep();
        if (baseGObject.getType() == GameElement.GROUND) {
            graphic.fillField(baseImage, anim.sub, maxWidth, maxHeight);
        } else {
            graphic.drawGameObject(baseImage, anim.x - anim.w / 2, anim.y - anim.h / 2, anim.w, anim.h, anim.sub);
        }
    }

    public void update(){
        nextStep.offer(new InnerGO(baseGObject));
    }

    public static class InnerGO {
        public int x, y, w, h;
        public Direction direction;

        public InnerGO(GameObject go) {
            this.x = go.getX();
            this.y = go.getY();
            this.w = go.getWidth();
            this.h = go.getHeight();
            this.direction = go.getDirection();
        }
    }
}
