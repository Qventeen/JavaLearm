package com.jr.level.level34.sokoban.view.texture;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TextureAtlasResource {
    private Map<String, SubTexture> elements;

    public TextureAtlasResource(TextureAtlas atlas) {
        Objects.nonNull(atlas);
        init(atlas);
    }

    private void init(TextureAtlas atlas) {
        elements = atlas.getSubTextures().stream().collect(Collectors.toMap(SubTexture::getName, e -> e ));
    }


    public SubTexture getSubTexture(String key) {
        return elements.get(key);
    }

}

