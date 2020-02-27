package com.codegym.task.task18.task1808;

/* 
Splitting a file

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            String file3 = reader.readLine();

            FileInputStream f1 = new FileInputStream(file1);
            FileOutputStream f2 = new FileOutputStream(file2);
            FileOutputStream f3 = new FileOutputStream(file3);
            int count = f1.available();
            if (count%2==0) {
                byte[] arr = new byte[count/2];
                f1.read(arr);
                f2.write(arr);
                f1.read(arr);
                f3.write(arr);
            } else {
                byte[] arr = new byte[count/2+1];
                byte[] arr2 = new byte[count/2];
                f1.read(arr);
                f2.write(arr);
                f1.read(arr2);
                f3.write(arr2);
            }
            f1.close();
            f2.close();
            f3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
