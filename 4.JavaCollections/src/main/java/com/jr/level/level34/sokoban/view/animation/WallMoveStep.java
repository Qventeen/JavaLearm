package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.view.texture.SubTexture;

public class WallMoveStep extends BaseMoveStep {
    private static final SubTexture wallTexture = (SubTexture) resTextures.getObject(resStyle.getString("field.wall"));

    @Override
    public SubTexture nextStep(Direction direction) {
        return wallTexture;
    }

    @Override
    public SubTexture stop() {
        return wallTexture;
    }
}
