package com.codegym.task.task18.task1822;

/* 
Finding data inside a file

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fis = new FileInputStream(file);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = reader2.readLine())!=null) {
            String[] divided = line.split(" ");

            if(args[0].equals(divided[0])) {
                    System.out.print(line);
                    break;
            }

        }

        reader.close();
        reader2.close();
    }
}
