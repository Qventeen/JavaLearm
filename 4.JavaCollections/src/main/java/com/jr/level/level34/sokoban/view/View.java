package com.jr.level.level34.sokoban.view;

import com.jr.level.level34.sokoban.controller.Controller;
import com.jr.level.level34.sokoban.controller.EventListener;
import com.jr.level.level34.sokoban.model.GameObjects;
import com.jr.level.level34.sokoban.utils.RManager;
import com.jr.level.level34.sokoban.view.graphic.GraphicGameObjects;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private GameObjects oldGameObjects;
    private GraphicGameObjects currentGraphicGO;
    private int currentWidth;
    private int currentHeight;

    private Field field;
    private Timer timer = new Timer(35, this);


    private View(Controller controller)  {
        this.controller = controller;
        init();
    }

    private void init() {
        field = new Field(this);
        add(field);
        getGameObjects();
        timer = new Timer(1000 / Integer.parseInt(RManager.getResSettings().getString("fsp")), this);
    }

    public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }

    public void update(){
        if (currentGraphicGO != null)
            currentGraphicGO.update();
        timer.start();

    }

    public void levelCompleted(int level){
        update();
        timer.stop();
        JOptionPane.showMessageDialog(this, String.format("LEVEL %d - COMPLETED", level), "Level", JOptionPane.INFORMATION_MESSAGE);
        controller.startNextLevel();
    }

    public int selectLevel(){
        update();
        timer.stop();
        do {
            try {
                String result = JOptionPane.showInputDialog(this, "Select desired level", "Level selection", JOptionPane.QUESTION_MESSAGE);
                if(result == null) return -1;

                int level = Integer.parseInt(result);
                controller.selectLevel(level);
                return level;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Incorrect data. Want to ");
                return -1;
            }
        } while(true);
    }

    public GraphicGameObjects getGameObjects(){
        GameObjects newGameObjects = controller.getGameObjects();
        if(oldGameObjects == newGameObjects) {
            return currentGraphicGO;
        }
        oldGameObjects = newGameObjects;
        currentWidth = newGameObjects.getWidth();
        currentHeight = newGameObjects.getHeight();

        updateSize();


        currentGraphicGO =  new GraphicGameObjects(newGameObjects);
        return currentGraphicGO;
    }

    public int getCurrentWidth() {
        return currentWidth;
    }

    public int getCurrentHeight() {
        return currentHeight;
    }

    private void updateSize(){
        setSize(new Dimension(currentWidth, currentHeight));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(currentGraphicGO.isMoved()){
            timer.stop();
        }
        field.repaint();
    }

    public static View newInstance(Controller controller){
        View view = new View(controller);
        EventQueue.invokeLater(() ->{
            view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            view.updateSize();
            view.setLocationRelativeTo(null);
            view.setResizable(false);
            view.setTitle("Sokoban");
            view.setVisible(true);
        });
        return view;
    }
}
