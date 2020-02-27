package com.codegym.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Changing the encoding

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];
        BufferedReader brip = new BufferedReader(new FileReader(filename1));
        BufferedWriter bwr = new BufferedWriter(new FileWriter(filename2));
        while(brip.ready()) {
            String CurrentLine = brip.readLine();
            byte[] b = CurrentLine.getBytes(Charset.forName("Windows-1251"));
            String s = new String(b, Charset.forName("UTF-8"));
            bwr.write(s);
        }

        brip.close();
        bwr.close();
    }
}
