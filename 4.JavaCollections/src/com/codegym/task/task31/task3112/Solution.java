package com.codegym.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
File downloader

*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://codegym.cc/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        String fileSuffix = urlString.substring(urlString.lastIndexOf("."));
        String filePrefix = urlString.substring(urlString.lastIndexOf("/")+1,urlString.lastIndexOf("."));
        Path tempFile = Files.createTempFile(fileSuffix,filePrefix);
        Files.copy(inputStream,tempFile);
        Path resolved = downloadDirectory.resolve(filePrefix+fileSuffix);
        Files.move(tempFile,resolved);
        return resolved;
    }
}
