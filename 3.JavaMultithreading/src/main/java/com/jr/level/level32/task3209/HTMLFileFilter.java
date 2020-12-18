package com.jr.level.level32.task3209;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String fileName = f.getName().toLowerCase();
        //Файл либо директтория либо html либо htm
        boolean result = f.isDirectory() || fileName.endsWith(".html") || fileName.endsWith(".htm");
        return result;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
