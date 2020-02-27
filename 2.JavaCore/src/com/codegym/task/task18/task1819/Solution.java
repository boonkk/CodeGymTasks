package com.codegym.task.task18.task1819;

/* 
Combining files

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream f2 = new FileInputStream(file2);
        FileOutputStream f1 = new FileOutputStream(file1);
        FileInputStream f1i = new FileInputStream(file1);
        byte[] arr = new byte[f1i.available()];
        while(f1i.available()>0){

            f1i.read(arr);
        }
        while(f2.available()>0){
            f1.write(f2.read());
        }
        f1.write(arr);

        f1.close();
        f2.close();
        f1i.close();
    }
}
