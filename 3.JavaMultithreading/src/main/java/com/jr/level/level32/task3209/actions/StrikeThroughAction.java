package com.jr.level.level32.task3209.actions;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class StrikeThroughAction extends StyledEditorKit.StyledTextAction {

    public StrikeThroughAction() {
        super(StyleConstants.StrikeThrough.toString());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        //Получить ссылку на редактор отправивший событие
        JEditorPane editor = getEditor(actionEvent);

        //Если редактор получен
        if (editor != null) {
            //Получить входные атрибуты редактора
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            //Создать набора простых атрибутов
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            //Использовать статические функции класса StyleConstants для
            //установки/отмены свойства зачеркнутости текста переданному набору атрибутов
            StyleConstants.setStrikeThrough(simpleAttributeSet, !StyleConstants.isStrikeThrough(mutableAttributeSet));
            //Установить подготовленный набор атрибутов
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
