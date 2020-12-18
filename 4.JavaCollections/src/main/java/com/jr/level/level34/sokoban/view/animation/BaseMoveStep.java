package com.jr.level.level34.sokoban.view.animation;

import com.jr.level.level34.sokoban.model.Direction;
import com.jr.level.level34.sokoban.utils.RManager;
import com.jr.level.level34.sokoban.view.texture.SubTexture;
import java.util.ResourceBundle;

public abstract class BaseMoveStep implements MoveStep {
    protected static ResourceBundle resStyle = RManager.getResStyle();
    protected static ResourceBundle resCharacter = RManager.getResPlayer();
    protected static ResourceBundle resTextures = RManager.getResSubTexture();

    @Override
    public abstract SubTexture nextStep(Direction direction);

    @Override
    public abstract SubTexture stop();

}
