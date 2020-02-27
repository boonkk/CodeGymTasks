package com.codegym.task.task19.task1923;

/* 
Words with numbers

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));


        while (reader.ready()) {
            String line = reader.readLine();
            String[] arr = line.split(" ");
            for (String s:arr) {
                if(s.matches("(.*)[0-9](.*)")){
                    writer.write(s + " ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
