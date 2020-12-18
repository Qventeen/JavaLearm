package com.jr.level.level32.task3209.actions;

import com.jr.level.level32.task3209.View;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class RedoAction extends AbstractAction {
    private View view;

    public RedoAction(View view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.redo();
    }
}
