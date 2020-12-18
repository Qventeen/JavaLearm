package com.jr.level.level31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {
    private long countDirectories = -1;
    private long countFiles = 0;
    private long sizeDirectory = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Path path = Paths.get(name);

        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
            return;
        }
        Solution solution = new Solution();
        Files.walkFileTree(path, solution);
        System.out.println("Всего папок - " + solution.countDirectories);
        System.out.println("Всего файлов - " + solution.countFiles);
        System.out.println("Общий размер - " + solution.sizeDirectory);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
       if(Files.isRegularFile(file)){
            this.countFiles++;
            this.sizeDirectory += attrs.size();
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        this.countDirectories++;
        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
