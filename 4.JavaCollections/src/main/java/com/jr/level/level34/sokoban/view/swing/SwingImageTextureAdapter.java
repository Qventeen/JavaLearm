package com.jr.level.level34.sokoban.view.swing;

import com.jr.level.level34.sokoban.view.texture.Texture;
import java.awt.*;

public class SwingImageTextureAdapter<T extends Image> implements Texture {
    private T image;

    public SwingImageTextureAdapter(T image) {
        this.image = image;
    }

    @Override
    public T getInnerImage() {
        return image;
    }
}
