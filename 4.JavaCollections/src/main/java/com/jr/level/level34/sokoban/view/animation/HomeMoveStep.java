package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.view.texture.SubTexture;

public class HomeMoveStep extends BaseMoveStep {
    private static final SubTexture homeTexture = (SubTexture) resTextures.getObject(resStyle.getString("field.home"));

    @Override
    public SubTexture nextStep(Direction direction) {
        return homeTexture;
    }

    @Override
    public SubTexture stop() {
        return homeTexture;
    }
}
