package com.jr.level.level34.sokoban.view.graphic;

import com.jr.level.level34.sokoban.view.texture.SubTexture;
import com.jr.level.level34.sokoban.view.texture.Texture;

public interface GraphicBackend {
    void drawGameObject(Texture image, int x, int y, int w, int h, SubTexture subTexture);
    void fillField(Texture image, SubTexture subTexture, int width, int height);
}
