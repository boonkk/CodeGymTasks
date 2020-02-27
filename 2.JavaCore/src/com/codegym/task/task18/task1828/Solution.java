package com.codegym.task.task18.task1828;

/* 
Prices 2

*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader brFile = new BufferedReader(new FileReader(fileName));

        String line = null;
        while ((line = brFile.readLine()) != null) {
            map.put(Integer.parseInt(line.substring(0, 8).trim()), line.substring(8));
        }

        int id = Integer.parseInt(args[1]);

        switch (args[0]) {
            case "-u" :
                String update = String.format("%-30s%-8s%-4s", args[2], args[3], args[4]);
                map.replace(id, update);
                break;
            case "-d" :
                map.remove(id);
                break;
        }

        FileWriter fw = new FileWriter(fileName);

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            fw.write(Integer.toString(entry.getKey()));
            for (int i = 0; i < 8 - Integer.toString(entry.getKey()).length(); i++) {
                fw.write(' ');
            }
            fw.write(entry.getValue());
            fw.write('\n');
            System.out.println();
        }

        reader.close();
        fw.close();
        brFile.close();
    }
}
