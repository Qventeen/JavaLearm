package com.jr.level.level34.sokoban.view;

import com.jr.level.level34.sokoban.controller.EventListener;
import com.jr.level.level34.sokoban.utils.RManager;
import com.jr.level.level34.sokoban.view.graphic.GraphicBackend;
import com.jr.level.level34.sokoban.view.graphic.GraphicGameObject;
import com.jr.level.level34.sokoban.view.graphic.GraphicGameObjects;


import com.jr.level.level34.sokoban.view.swing.SwingGraphicBackend;
import com.jr.level.level34.sokoban.view.swing.SwingImageTextureAdapter;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

import static com.jr.level.level34.sokoban.model.Direction.*;
import static java.awt.RenderingHints.*;
import static java.awt.event.KeyEvent.*;


public class Field extends JPanel {
    private Map<RenderingHints.Key, Object> hints = new HashMap<>();

    private SwingImageTextureAdapter<Image> image;
    private EventListener eventListener;
    private View view;


    public Field(View view) {
        this.view = view;
        URL name = getClass().getResource(RManager.getPropGame("textures.image"));
        Image tmpImage = null;
        try {
            tmpImage = ImageIO.read(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = new SwingImageTextureAdapter<>(tmpImage);
        addKeyListener(new KeyHandler());
        setFocusable(true);

        hints.put(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        hints.put(KEY_TEXT_ANTIALIASING, VALUE_TEXT_ANTIALIAS_ON);
        hints.put(KEY_FRACTIONALMETRICS, VALUE_FRACTIONALMETRICS_ON);
        hints.put(KEY_RENDERING, VALUE_RENDER_QUALITY);
        hints.put(KEY_STROKE_CONTROL, VALUE_STROKE_NORMALIZE);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHints(hints);
        GraphicBackend graphic = new SwingGraphicBackend(g);
        GraphicGameObjects go = view.getGameObjects();

        GraphicGameObject ground = go.getGround();
        ground.draw(graphic, image, getWidth(), getHeight());

        for(GraphicGameObject wall: go.getWalls()){
            wall.draw(graphic, image, getWidth(), getHeight());
        }

        for(GraphicGameObject box: go.getBoxes()){
            box.draw(graphic, image, getWidth(), getHeight());
        }

        for(GraphicGameObject home: go.getHomes()){
            home.draw(graphic, image, getWidth(), getHeight());
        }
        go.getPlayer().draw(graphic, image, getWidth(), getHeight());
    }


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()){
                case VK_LEFT: eventListener.move(LEFT); break;
                case VK_RIGHT: eventListener.move(RIGHT); break;
                case VK_UP: eventListener.move(UP); break;
                case VK_DOWN: eventListener.move(DOWN); break;
                case VK_R: eventListener.restart(); break;
                case VK_N: eventListener.startNextLevel(); break;
                case VK_S: eventListener.selectLevel(view.selectLevel()); break;
                case VK_Q:
                case VK_ESCAPE: System.exit(0);
            }
        }
    }

}
