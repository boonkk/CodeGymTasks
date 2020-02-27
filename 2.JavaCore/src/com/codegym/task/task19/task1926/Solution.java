package com.codegym.task.task19.task1926;

/* 
Mirror image

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileReader fr = new FileReader(fileName);
        BufferedReader bfr = new BufferedReader(fr);

        while (bfr.ready()) {
            StringBuffer sb = new StringBuffer();
            sb.append(bfr.readLine());
            String s = sb.reverse().toString();
            System.out.println(s);
            sb.delete(0,sb.length());
        }
        fr.close();
        bfr.close();
    }
}
