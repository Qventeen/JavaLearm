package com.jr.level.level34.sokoban.utils;

import com.jr.level.level34.sokoban.view.texture.TextureAtlas;
import com.jr.level.level34.sokoban.view.texture.TextureAtlasResourceBundle;
import java.util.ResourceBundle;


public class RManager {
    private static final ResourceBundle resGame = ResourceBundle.getBundle("game");
    private static final ResourceBundle resStyle = ResourceBundle.getBundle(resGame.getString("textures.style"));
    private static final ResourceBundle resPlayer = ResourceBundle.getBundle(resGame.getString("textures.player"));
    private static final ResourceBundle resSubTexture = new TextureAtlasResourceBundle(TextureAtlas.getInstance());
    private static final ResourceBundle resSettings = ResourceBundle.getBundle(resGame.getString("settings"));

    public static ResourceBundle getResSettings() {
        return resSettings;
    }

    public static ResourceBundle getResStyle() {
        return resStyle;
    }

    public static ResourceBundle getResPlayer() {
        return resPlayer;
    }

    public static ResourceBundle getResSubTexture() {
        return resSubTexture;
    }

    public static ResourceBundle getResGame() {
        return resGame;
    }
}




