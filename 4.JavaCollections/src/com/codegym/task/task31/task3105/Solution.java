package com.codegym.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.cert.PKIXRevocationChecker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Adding a file to an archive

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        ZipInputStream zis = new ZipInputStream(fis);

        FileOutputStream fos = new FileOutputStream(args[1]);
        ZipOutputStream zos = new ZipOutputStream(fos);

        Map<String, byte[]> tempValues = saveFilesInMap(zis);
        addFileToArchive(args[0],zos);
        addByteArraysToArchive(tempValues,zos);



        fis.close();
        zis.close();

        fos.close();
        zos.close();

    }

    public static Map<String, byte[]> saveFilesInMap(ZipInputStream zipInputStream) {
        Map<String, byte[]> archiveContents = new HashMap<>();
        ZipEntry ze;
        try {
            while ((ze = zipInputStream.getNextEntry()) != null) {
                int len;
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((len = zipInputStream.read(buffer)) > 0) {
                    baos.write(buffer, 0, len);
                }
                archiveContents.put(ze.getName(), baos.toByteArray());
                baos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archiveContents;
    }

    public static void addByteArraysToArchive(Map<String, byte[]> byteArrays, ZipOutputStream zipOutputStream) {
        for (Map.Entry<String, byte[]> entry : byteArrays.entrySet()) {
            String name = entry.getKey();
            byte[] bytes = entry.getValue();
            try {
                ZipEntry zipEntry = new ZipEntry(name);
                zipEntry.setSize(bytes.length);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addFileToArchive(String fileToBeAdded, ZipOutputStream zipOutputStream) {
        try {
            zipOutputStream.putNextEntry(new ZipEntry("new/" + Paths.get(fileToBeAdded).getFileName()));
            Files.copy(Paths.get(fileToBeAdded), zipOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
