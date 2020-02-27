package com.codegym.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
File in a static block

*/

public class Solution {
    public static List<String> lines = new ArrayList<>();
    static {
        try {
            FileInputStream fis = new FileInputStream(Statics.FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = reader.readLine();
            while(line!=null) {
                lines.add(line);
                line=reader.readLine();
            }
        }catch(Exception e){

        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
