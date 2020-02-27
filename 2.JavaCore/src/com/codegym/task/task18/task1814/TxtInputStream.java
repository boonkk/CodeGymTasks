package com.codegym.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
UnsupportedFileName

*/

public class TxtInputStream extends FileInputStream {
    FileOutputStream original;
    public TxtInputStream(String fileName) throws UnsupportedFileNameException, FileNotFoundException, IOException {
        super(fileName);
        if (fileName.endsWith(".txt")){
            //original=new FileOutputStream(fileName);
        } else{
            super.close();
            throw new UnsupportedFileNameException();
        }


    }

    public static void main(String[] args) {
    }
}

