package com.jr.level.level32.task3209;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Controller {
    //members
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view){
        this.view = view;
    }

    public void init(){
        createNewDocument();
    }
    public void exit(){
        System.exit(0);
    }

    public void resetDocument() {
        if (document != null)
            document.removeUndoableEditListener(view.getUndoListener());
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }
    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try{
            htmlEditorKit.read(stringReader, document, 0);
        }catch(Exception e){
            ExceptionHandler.log(e);
        }
    }
    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    //main method
    public static void main(String[] args){
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }

    //getters
    public HTMLDocument getDocument() {
        return document;
    }

    //File commands
    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("~"));
        //Установить фильтр
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Открыть диалог
        int approve = jFileChooser.showOpenDialog(view);
        if(approve == JFileChooser.APPROVE_OPTION){
            //Установить выбранный файл текущим
            currentFile = jFileChooser.getSelectedFile();

            //Сбросить обрабатываемый документ
            resetDocument();

            //Установить заголовок фрейма из файла
            view.setTitle(currentFile.getName());

            //Прочитать выбранный файл в документ
            try(FileReader fileReader = new FileReader(currentFile)){
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                htmlEditorKit.read(fileReader,document,0);
                view.update();
                view.resetUndo();
            }catch(Exception e){
                ExceptionHandler.log(e);
            }
        }


    }

    public void saveDocument() {
        view.selectHtmlTab();
        if(currentFile == null){
            saveDocumentAs();
        }else{
            try(FileWriter fileWriter = new FileWriter(currentFile)) {
                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                //Записать документ в файл
                htmlEditorKit.write(fileWriter,document,0,document.getLength());
                fileWriter.flush();
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        //Выбрать вкладку HTML
        view.selectHtmlTab();

        JFileChooser jFileChooser = new JFileChooser();
        //Установить фильтр
        jFileChooser.setFileFilter(new HTMLFileFilter());
        //Установить текущий каталог
        jFileChooser.setCurrentDirectory(new File("~"));
        //Показать окно сохранения файла
        int result = jFileChooser.showSaveDialog(view);
        //Если файл выбран успешно
        if(result == JFileChooser.APPROVE_OPTION){
            //Получить выбранный файл (Путь файла)
            currentFile = jFileChooser.getSelectedFile();
            //Назначить HTML вкладке текущее имя файла
            view.setTitle(currentFile.getName());
            saveInFile(currentFile);
        }


    }

    private void saveInFile(File file){
        try(FileWriter fileWriter = new FileWriter(file)) {
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            //Записать документ в файл
            htmlEditorKit.write(fileWriter,document,0,document.getLength());
            fileWriter.flush();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
}
