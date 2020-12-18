package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.view.texture.SubTexture;

public class GroundMoveStep extends BaseMoveStep {
    private static final SubTexture groundTexture = (SubTexture) resTextures.getObject(resStyle.getString("field.ground"));

    @Override
    public SubTexture nextStep(Direction direction) {
        return groundTexture;
    }

    @Override
    public SubTexture stop() {
        return groundTexture;
    }
}
