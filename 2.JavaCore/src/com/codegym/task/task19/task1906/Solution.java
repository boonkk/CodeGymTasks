package com.codegym.task.task19.task1906;

/* 
Even characters

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);
        while (fr.ready()) {
            fr.read();
            fw.write(fr.read());
        }
        fr.close();
        fw.close();
    }
}
