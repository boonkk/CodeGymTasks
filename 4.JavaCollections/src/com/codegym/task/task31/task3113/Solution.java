package com.codegym.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
What's in the folder?

*/
public class Solution {
    public static int dirCount = 0;
    static int fileCount = 0;
    static int totalSize = 0;

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fPath = bufferedReader.readLine();
        bufferedReader.close();

        Path startFile = Paths.get(fPath);

        if (!Files.isDirectory(startFile)) {
            System.out.println(fPath + " is not a folder");
            return;
        } else {
            Files.walkFileTree(startFile, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (attrs.isRegularFile()) {
                        fileCount++;
                        totalSize += attrs.size();
                    }

                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

                    dirCount += 1;



                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("Total folders: " + --dirCount);
            System.out.println("Total files: " + fileCount);
            System.out.println("Total size: " + totalSize);
        }



    }
}
