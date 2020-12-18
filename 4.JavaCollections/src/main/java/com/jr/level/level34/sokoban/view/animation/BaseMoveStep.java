package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.view.texture.SubTexture;

public abstract class BaseMoveStep implements MoveStep {

    @Override
    public abstract SubTexture nextStep(Direction direction);

    @Override
    public abstract SubTexture stop();

}
