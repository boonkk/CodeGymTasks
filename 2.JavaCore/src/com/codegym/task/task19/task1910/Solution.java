package com.codegym.task.task19.task1910;

/* 
Punctuation

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(f1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(f2));

        while(br.ready()) {
            String s = br.readLine();
            s = s.replaceAll("\\p{Punct}","");
            bw.write(s);
        }
        br.close();
        bw.close();

    }
}
