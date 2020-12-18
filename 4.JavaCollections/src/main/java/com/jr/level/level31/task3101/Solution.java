package com.jr.level.level31.task3101;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* 
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) return;
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
//        File result = new File("/home/qventeen/test/FileUtils.java");
//        File path = new File("/home/qventeen/test/test/");
//        FileUtils.deleteDirectory(path);
//
//        FileUtils.createRandomFileArea(path, 4);

        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if(FileUtils.isExist(allFilesContent))
                    FileUtils.deleteFile(allFilesContent);

        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        List<File> fileList = new ArrayList<>();
        processFiles(path, fileList);
//        fileList.remove(allFilesContent);
        fileList.sort(Comparator.comparing(File::getName, String::compareTo));
        try(FileOutputStream fout = new FileOutputStream(allFilesContent)) {
            for (File file : fileList) {
                FileInputStream fin = new FileInputStream(file);
                byte[] buffer = new byte[fin.available()];
                int count = fin.read(buffer);
                fout.write(buffer, 0, count);
                fout.write('\n');
                fin.close();
            }
            fout.flush();
        }
    }

    public static void processFiles(File path, List<File> listFiles){
        if(!path.isDirectory()) return;

        for(File file: path.listFiles()){
            if(file.isDirectory()){
                processFiles(file, listFiles);
            }else if(file.length() <= 50){
                listFiles.add(file);
            }
        }
    }
}
