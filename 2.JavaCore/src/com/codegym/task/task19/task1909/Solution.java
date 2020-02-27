package com.codegym.task.task19.task1909;

/* 
Changing punctuation marks

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(file1);
        BufferedReader bfr = new BufferedReader(fr);
        FileWriter fw = new FileWriter(file2);
        BufferedWriter bfw = new BufferedWriter(fw);

        while(bfr.ready()){
            String line = bfr.readLine();
            line=line.replace(".","!");
            bfw.write(line);
            bfw.newLine();
        }
        fr.close();
        bfr.close();
        fw.close();
        bfw.close();

    }
}
