package com.jr.level.level34.sokoban.view.texture;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class BaseSubTexture implements SubTexture{
    @XmlAttribute private String name;
    @XmlAttribute private int x;
    @XmlAttribute private int y;
    @XmlAttribute private int width;
    @XmlAttribute private int height;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}

