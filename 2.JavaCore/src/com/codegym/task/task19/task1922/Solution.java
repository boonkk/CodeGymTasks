package com.codegym.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Searching for the right lines

*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("file");
        words.add("view");
        words.add("In");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        BufferedReader freader = new BufferedReader(new FileReader(filename));
        ArrayList<String> linesList = new ArrayList<>();
        int counter = 0;
        while (freader.ready()) {
            String line = freader.readLine();
            for (String s:words) {
                if(line.contains(s))
                    counter++;
            }
            if (counter == 2) {
                linesList.add(line);
            }
            counter = 0;
        }
        freader.close();
        for (String s : linesList)
            System.out.println(s);
    }
}
