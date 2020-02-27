package com.codegym.task.task32.task3210;


import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Using RandomAccessFile

*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0],"rw");
        Long pos = Long.parseLong(args[1]);
        raf.seek(pos);
        byte[] textBytes=new byte[args[2].length()];
        raf.read(textBytes,0,args[2].length());
        raf.seek(raf.length());
        if(new String(textBytes).equals(args[2])) {
            raf.write("true".getBytes());
        }
        else {
            raf.write("false".getBytes());
        }
    }
}