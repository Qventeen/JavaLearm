package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.view.texture.SubTexture;

public class BoxMoveStep extends BaseMoveStep {
    private static final SubTexture boxTexture = (SubTexture) resTextures.getObject(resStyle.getString("field.box"));

    @Override
    public SubTexture nextStep(Direction direction) {
        return boxTexture;
    }

    @Override
    public SubTexture stop() {
        return boxTexture;
    }
}
