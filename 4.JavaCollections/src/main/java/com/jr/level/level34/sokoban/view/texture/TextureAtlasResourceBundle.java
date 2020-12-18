package com.jr.level.level34.sokoban.view.texture;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TextureAtlasResourceBundle extends ResourceBundle {
    private Map<String, SubTexture> elements;

    public TextureAtlasResourceBundle(TextureAtlas atlas) {
        Objects.nonNull(atlas);
        init(atlas);
    }

    private void init(TextureAtlas atlas) {
        elements = atlas.getSubTextures().stream().collect(Collectors.toMap(SubTexture::getName, e -> e ));
    }

    @Override
    protected Object handleGetObject(String key) {
        return elements.get(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return Collections.enumeration(elements.keySet());
    }
}

