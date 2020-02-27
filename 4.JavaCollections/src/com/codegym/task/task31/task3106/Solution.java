package com.codegym.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


/*
Unzipping a file

*/
public class Solution {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) throws IOException {
        List<String> argsList = new ArrayList<>();
        for(int i=1;i<args.length;i++)
        {
            argsList.add(args[i]);
        }
        Collections.sort(argsList);
        List<FileInputStream> streamList = new ArrayList<>();
        for(String s : argsList) {
            streamList.add(new FileInputStream(s));
        }
        ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(streamList)));
        try {
            for(ZipEntry entry = null; (entry = is.getNextEntry()) != null; ) {
                OutputStream os = new BufferedOutputStream(new FileOutputStream(args[0]));
                try {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for(int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                } finally {
                    os.close();
                }
            }
        } finally {
            is.close();
        }




    }

}
