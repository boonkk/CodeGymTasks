package com.codegym.task.task32.task3202;

import java.io.*;

/* 
Reading from a stream

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            StringWriter stringWriter = new StringWriter();
            while ( bufferedReader.ready() ) {
                stringWriter.append(bufferedReader.readLine());
            }
                return stringWriter;
        } catch (Exception e) {
            return new StringWriter();
        }
    }
}