package com.codegym.task.task18.task1818;

/* 
Two in one

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();
        FileInputStream fis2 = new FileInputStream(f2);
        FileOutputStream fis1 = new FileOutputStream(f1);
        FileInputStream fis3 = new FileInputStream(f3);

        while(fis2.available()>0){
            fis1.write(fis2.read());
        }
        while(fis3.available()>0){
            fis1.write(fis3.read());
        }

        reader.close();
        fis1.close();
        fis2.close();
        fis3.close();
    }
}
