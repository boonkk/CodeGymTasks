package com.codegym.task.task18.task1817;

/* 
Spaces

*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int spaces = 0;
        int others = 0;
        while(fis.available()>0) {
            int a = fis.read();
            if ((char) a == ' '){
                spaces++;
                others++;
            }else others++;
        }
        double s =(double)spaces/(double)others*100;
                s = Math.round(s * 100);
        s = s/100;


        System.out.print(s);
        fis.close();
    }
}
