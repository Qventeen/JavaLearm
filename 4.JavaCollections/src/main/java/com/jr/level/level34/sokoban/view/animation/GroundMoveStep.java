package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.utils.RManager;
import com.jr.level.level34.sokoban.view.texture.SubTexture;

public class GroundMoveStep extends BaseMoveStep {
    private static final SubTexture groundTexture = RManager.getSubTexture(RManager.getPropStyle("field.ground"));

    @Override
    public SubTexture nextStep(Direction direction) {
        return groundTexture;
    }

    @Override
    public SubTexture stop() {
        return groundTexture;
    }
}
