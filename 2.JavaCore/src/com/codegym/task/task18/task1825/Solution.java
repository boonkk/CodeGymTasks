package com.codegym.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Building a file

*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName;

        TreeSet<String> filesNames = new TreeSet<>();

        while (!(fileName = reader.readLine()).equals("end")) filesNames.add(fileName);

        String outputFileName = "";

        String[] words = filesNames.first().split("\\.");

        for (int i = 0; i < words.length; i++) {

            if (i == words.length - 2) {
                outputFileName += words[i];
                break;
            }
            outputFileName += words[i] + ".";
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFileName, true));

        BufferedReader fileReader = null;

        for (String s : filesNames) {

            fileReader = new BufferedReader(new FileReader(s));

            String line;

            while ((line = fileReader.readLine()) != null) fileWriter.write(line);
            fileReader.close();
        }

        reader.close();
        fileWriter.close();
        fileReader.close();
    }

}