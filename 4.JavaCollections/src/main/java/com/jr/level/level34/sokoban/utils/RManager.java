package com.jr.level.level34.sokoban.utils;

import com.jr.level.level34.sokoban.view.texture.SubTexture;
import com.jr.level.level34.sokoban.view.texture.TextureAtlas;
import com.jr.level.level34.sokoban.view.texture.TextureAtlasResource;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;


public class RManager {
    private static final Properties propGame = rLoad("/sokoban/game.properties");
    private static final Properties propStyle = rLoad(propGame.getProperty("textures.style"));
    private static final Properties propPlayer = rLoad(propGame.getProperty("textures.player"));
    private static final Properties propSetting = rLoad(propGame.getProperty("settings"));
    private static final TextureAtlasResource resSubTexture = new TextureAtlasResource(TextureAtlas.getInstance());

    public static String getPropGame(String propName) {
        return propGame.getProperty(propName);
    }

    public static String getPropStyle(String propName) {
        return propStyle.getProperty(propName);
    }

    public static String getPropPlayer(String propName) {
        return propPlayer.getProperty(propName);
    }

    public static String getPropSetting(String propName) {
        return propSetting.getProperty(propName);
    }

    public static SubTexture getSubTexture(String subTextureName) {
        return resSubTexture.getSubTexture(subTextureName);
    }

    private static Properties rLoad(String resourceName){
        Properties result = new Properties();
        try(InputStream is = RManager.class.getResourceAsStream(resourceName)){
            result.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}




