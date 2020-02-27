package com.codegym.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Caesar cipher

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  // Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter stringWriter = new StringWriter();
        try{
            if (reader != null){
                int readin;
                while ((readin = reader.read()) > -1){
                    stringWriter.write((char)(readin + key));
                }
            } else return "";
            return stringWriter.toString();
        } catch (Exception e) {
            return "";
        }

    }
}
