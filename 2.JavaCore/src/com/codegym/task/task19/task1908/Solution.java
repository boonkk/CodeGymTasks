package com.codegym.task.task19.task1908;

/* 
Picking out numbers

*/

import java.io.*;
import java.text.ParseException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();


        FileReader fr = new FileReader(file1);
        BufferedReader bfr = new BufferedReader(fr);

        StringBuffer sb = new StringBuffer();
        String line = bfr.readLine();
        String[] arr = line.split(" ");
        StringBuffer sbfr = new StringBuffer();
        for (String s : arr) {
            try{
                Integer.parseInt(s);
                sbfr.append(s).append(" ");
            } catch (Exception e) {

            }
        }
        fr.close();
        bfr.close();


        FileWriter fw = new FileWriter(file2);
        BufferedWriter bfw = new BufferedWriter(fw);

        bfw.write(sbfr.toString().trim());

        bfw.close();
        fw.close();
    }

}
