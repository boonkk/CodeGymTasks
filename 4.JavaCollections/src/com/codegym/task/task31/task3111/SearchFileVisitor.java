package com.codegym.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName="";
    private String partOfContent="";
    private int minSize=-1;
    private int maxSize=-1;
    private List<Path> foundFiles= new ArrayList<>();

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

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // File size: content.length
        String fileContent = new String(content);
        if(minSize<0)
            minSize=0;
        if(maxSize<0)
            maxSize=Integer.MAX_VALUE;
        if(file.getFileName().toString().contains(partOfName) && content.length>minSize && content.length<maxSize && fileContent.contains(partOfContent))
            foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
