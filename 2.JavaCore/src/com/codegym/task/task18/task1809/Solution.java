package com.codegym.task.task18.task1809;

/* 
Reversing a file

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String file1 = reader.readLine();
            String file2 = reader.readLine();
            FileInputStream f1 = new FileInputStream(file1);
            FileOutputStream f2 = new FileOutputStream(file2);
            if (f1.available()>0) {
                int count = f1.available();
                byte[] arr = new byte[count];
                f1.read(arr);
                for (int i=arr.length-1; i>=0;i--) {
                    f2.write(arr[i]);
                }
            }
            f1.close();
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
