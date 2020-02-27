package com.codegym.task.task19.task1925;

/* 
Long words

*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuilder res = new StringBuilder();
        FileReader fr = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fr);

        while (reader.ready()) {
            String[] s = reader.readLine().trim().split(" ");

            for (String word : s) {
                if (word.length() > 6) {
                    res.append(word).append(',');
                }
            }
        }
        fr.close();
        reader.close();

        FileWriter writer = new FileWriter(args[1]);
        writer.write(res.substring(0, res.length() - 1));
        writer.close();
    }
}