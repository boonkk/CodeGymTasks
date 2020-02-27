package com.codegym.task.task18.task1827;

/* 
Prices

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length == 0) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        ArrayList<String> list = new ArrayList<>();

        //pisanie linijek do listy
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        br.close();

        StringBuilder newLine = new StringBuilder();
        newLine.append(getNewId(list));

        newLine.append(String.format("%-30s%-8s%-4s",args[1],args[2],args[3]));

        FileWriter fw = new FileWriter(fileName);
        for (String s : list) {
            fw.write(s);
            fw.write('\n');
        }
        fw.write(newLine.toString());
        fw.close();

    }

    private static String getNewId(ArrayList<String> list) {
        int maxId = 0;
        for (String s : list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                if (s.charAt(i) != ' ') {
                    sb.append(s.charAt(i));
                }
            }
            maxId = Integer.parseInt(sb.toString()) > maxId ? Integer.parseInt(sb.toString()) : maxId;
        }
        StringBuilder newId = new StringBuilder();
        newId.append(maxId + 1);
        for (int i = (maxId + "").length(); i < 8; i++) {
            newId.append(' ');
        }
        return newId.toString();
    }
}

