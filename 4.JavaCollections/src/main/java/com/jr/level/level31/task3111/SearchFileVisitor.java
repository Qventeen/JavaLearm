package com.jr.level.level31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = null;
    private String partOfContent = null;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if(     nameFileConditionTest(file) &&
                contentFileConditionTest(content) &&
                maxSizeConditionTest(content.length) &&
                minSizeConditionTest(content.length)
        )
        {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    private boolean maxSizeConditionTest(int fileSize){
        return maxSize < 0 || fileSize <= maxSize;
    }

    private boolean minSizeConditionTest(int fileSize){
        return minSize < 0 || fileSize >= minSize;
    }

    private boolean nameFileConditionTest(Path file){
        return partOfName == null || file.getFileName().toString().contains(partOfName);
    }

    private boolean contentFileConditionTest(byte [] contentFile){
        return partOfContent == null || (new String(contentFile)).contains(partOfContent);
    }


}

