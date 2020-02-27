package com.codegym.task.task19.task1902;

/* 
Adapter

*/



import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;
    public static void main(String[] args) {

    }
    public AdapterFileOutputStream(FileOutputStream stream) {
        this.fileOutputStream = stream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] arr = s.getBytes();
        fileOutputStream.write(arr);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }
}

