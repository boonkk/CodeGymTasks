package com.codegym.task.task18.task1820;

/* 
Rounding numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileOutputStream fos = new FileOutputStream(file2);
        FileInputStream fis = new FileInputStream(file1);

        byte[] input = new byte[fis.available()];
        fis.read(input);
        fis.close();
        //convert array to String
        String inputString = "";
        for (byte b : input) {
            inputString += (char)b;
        }
        String[] arr = inputString.split(" ");


        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append((int) Math.round(Double.parseDouble(s)));
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        for(char x : sb.toString().toCharArray()) fos.write(x);

        fos.close();
    }
}
