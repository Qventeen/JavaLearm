package com.jr.level.level34.sokoban.view.swing;

import com.jr.level.level34.sokoban.view.graphic.GraphicBackend;
import com.jr.level.level34.sokoban.view.texture.SubTexture;
import com.jr.level.level34.sokoban.view.texture.Texture;
import java.awt.*;

public class SwingGraphicBackend implements GraphicBackend {
    private Graphics g;

    public SwingGraphicBackend(Graphics instance) {
        this.g = instance;
    }

    @Override
    public void drawGameObject(Texture image, int x, int y, int width, int height, SubTexture subTexture) {
        Image img = image.getInnerImage();
        g.drawImage(
                img, x, y, x + width, y + height,
                subTexture.getX(), subTexture.getY(),
                subTexture.getX() + subTexture.getWidth(),
                subTexture.getY() + subTexture.getHeight(), null);
    }

    @Override
    public void fillField(Texture image, SubTexture subTexture, int maxWidth, int maxHeight) {
        SubTexture s = subTexture;
        Image img = image.getInnerImage();
        int xStep = subTexture.getWidth();
        int yStep = subTexture.getHeight();

        for(int y = 0; y < maxHeight; y += yStep){
            for(int x = 0; x < maxWidth; x += xStep){
                g.drawImage(
                        img, x, y, x + xStep, y + yStep,
                        s.getX(), s.getY(), s.getX() + xStep, s.getY() + yStep, null
                );
            }
        }
    }
}
