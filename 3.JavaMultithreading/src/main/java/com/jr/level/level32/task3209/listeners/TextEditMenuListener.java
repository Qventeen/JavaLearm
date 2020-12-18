package com.jr.level.level32.task3209.listeners;

import com.jr.level.level32.task3209.View;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        boolean htmlTabSelectable = view.isHtmlTabSelected();

        for(Component item: ((JMenu) menuEvent.getSource()).getMenuComponents()){
            item.setEnabled(htmlTabSelectable);
        }
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }


}
