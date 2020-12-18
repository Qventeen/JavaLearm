package com.jr.level.level31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDirectory = new File(root);
        if(!rootDirectory.exists()) return null;

        List<String> listFiles = new ArrayList<>();
        if(rootDirectory.isFile()){
            listFiles.add(rootDirectory.getAbsolutePath());
        }
        else {
            Queue<File> fileQueue = new LinkedList<>();
            fileQueue.offer(rootDirectory);
            while(!fileQueue.isEmpty()){
                for(File file: fileQueue.poll().listFiles()){
                    if(file.isDirectory()){
                        fileQueue.offer(file);
                    } else {
                        listFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return listFiles;
    }

    public static void main(String[] args) throws IOException {
        List<String> files = getFileTree("/home/qventeen/MEGAsyncBooks/РОСТ");
        for(String string: files){
            System.out.println(string);
        }
    }
}
