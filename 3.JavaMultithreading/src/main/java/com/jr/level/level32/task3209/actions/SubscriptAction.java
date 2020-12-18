package com.jr.level.level32.task3209.actions;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class SubscriptAction extends StyledEditorKit.StyledTextAction{
    public SubscriptAction() {
        super(StyleConstants.Subscript.toString());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if(editor !=null){
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSubscript(simpleAttributeSet, !StyleConstants.isSubscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }


    }
}
