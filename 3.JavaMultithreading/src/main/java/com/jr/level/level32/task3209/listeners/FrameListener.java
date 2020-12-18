package com.jr.level.level32.task3209.listeners;

import com.jr.level.level32.task3209.View;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameListener extends WindowAdapter {
    private View view;

    public FrameListener(View view){
        this.view = view;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        view.exit();
        super.windowClosing(e);
    }
}
