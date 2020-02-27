package com.codegym.task.task18.task1813;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream

*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    public FileOutputStream original;

    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException {
        super(fileName);
        this.original = file;
    }


    @Override
    public void close() throws IOException {
        original.flush();
        original.write("CodeGym © All rights reserved.".getBytes());
        original.close();
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }



    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
