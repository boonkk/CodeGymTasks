package com.codegym.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Transactionality

*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> linesForRemoval = new ArrayList<>();

    public static void main(String[] args) throws CorruptedDataException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1="";
        String file2="";
        try {
        file1 = reader.readLine();
        file2 = reader.readLine();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));
        String line;


            while ((line=fileReader1.readLine())!=null) {
                allLines.add(line);
            }
            while ((line=fileReader2.readLine())!=null) {
                linesForRemoval.add(line);
            }
            reader.close();
            fileReader1.close();
            fileReader2.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
        Solution data = new Solution();
        data.joinData();

    }

    public void joinData() throws CorruptedDataException {



        for(String line:linesForRemoval){
            if (allLines.contains(line)){
                allLines.remove(line);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }


    }
}
