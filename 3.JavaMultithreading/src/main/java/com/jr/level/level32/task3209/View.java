package com.jr.level.level32.task3209;

import com.jr.level.level32.task3209.listeners.FrameListener;
import com.jr.level.level32.task3209.listeners.TabbedPaneChangeListener;
import com.jr.level.level32.task3209.listeners.UndoListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class View extends JFrame implements ActionListener {

    //Members
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    //Constructors
    public View(){
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            ExceptionHandler.log(e);
        }
    }

    //inits
    public void init(){

        initGui();
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
        setVisible(true);
    }
    public void initMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this,jMenuBar);
        MenuHelper.initEditMenu(this,jMenuBar);
        MenuHelper.initStyleMenu(this,jMenuBar);
        MenuHelper.initAlignMenu(this,jMenuBar);
        MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this,jMenuBar);
        MenuHelper.initHelpMenu(this,jMenuBar);
        this.getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }
    public void initEditor(){
        //Добавляем вкладку HTML
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPaneHtml = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", jScrollPaneHtml);

        //Добавляем вкладку текстового редактора
        JScrollPane jScrollPaneText = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", jScrollPaneText);

        //Установим размер tabbedPane
        tabbedPane.setPreferredSize(new Dimension(1000,800));

        //Установим слушателя изменений для tabbedPane
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);

        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }
    public void initGui(){
        initMenuBar();
        initEditor();
        this.pack();
    }

    //getters&setters
    public Controller getController() {
        return controller;
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public UndoListener getUndoListener(){
        return undoListener;
    }


    //actions
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "Новый": controller.createNewDocument(); break;
            case "Открыть": controller.openDocument(); break;
            case "Сохранить": controller.saveDocument(); break;
            case "Сохранить как...": controller.saveDocumentAs(); break;
            case "Выход": controller.exit(); break;
            case "О программе": showAbout(); break;
            default: ExceptionHandler.log(new Exception("Ошибочная команад"));
        }

    }
    public void selectedTabChanged(){
        int index = tabbedPane.getSelectedIndex();
        //Если выбрана вкладка HTML
        if(index == 0){
            controller.setPlainText(plainTextPane.getText());
        }
        //Если выбрана вкладка Текст
        else if(index == 1){
            plainTextPane.setText(controller.getPlainText());
        }
        this.resetUndo();

    }
    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    //controls
    public void exit(){
        controller.exit();
    }
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){
        String about = "Simple HTML Note" +
                "\nПростой редактор для создания и редактирования HTML" +
                "\nАвтор: Сергей Тугаенко" +
                "\nmail: qventeen@gmail.com";

        JOptionPane.showMessageDialog(
                this,
                about,
                "О программе",
                JOptionPane.INFORMATION_MESSAGE);
    }


    //edits
    public void undo(){
        try {
            undoManager.undo();
        } catch(CannotUndoException e){
            ExceptionHandler.log(e);
        }
    }
    public void redo(){
        try {
            undoManager.redo();
        } catch(CannotRedoException e){
            ExceptionHandler.log(e);
        }
    }
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

    //tests
    public boolean canUndo(){
        return undoManager.canUndo();
    }
    public boolean canRedo(){
        return undoManager.canRedo();
    }
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }
}
