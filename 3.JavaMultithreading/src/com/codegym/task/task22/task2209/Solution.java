package com.codegym.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/*
Make a word chain

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "C:\\Users\\marci\\Downloads\\CodeGymTasks\\3.JavaMultithreading\\src\\com\\codegym\\task\\task22\\task2209\\ryba";
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line = fr.readLine();

        StringBuilder result = getLine(line.split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        ArrayList<String> list = new ArrayList<>();
        for(String word : words) {
            list.add(word);
        }
        ArrayList<String> forRemoval = (ArrayList<String>) list.clone();
        Iterator<String> iterator = list.iterator();

        ArrayList<String> result = new ArrayList<>();
        int bycprzyzwoity = 0;
        while(!forRemoval.isEmpty()) {
            String s = iterator.next();
            if(result.isEmpty()) {
                result.add(s);
                forRemoval.remove(s);
                continue;
            }
            for(int i=0; i<result.size();i++) {
                if(forRemoval.contains(s)) {
                    if( i == 0 && Character.toLowerCase(result.get(0).charAt(0)) == Character.toLowerCase(s.charAt(s.length() - 1)) ) {
                        result.add(0, s);
                        forRemoval.remove(s);
                        continue;
                    }
                    if(i == result.size()-1 && Character.toLowerCase(result.get(i).charAt(result.get(i).length()-1))==Character.toLowerCase(s.charAt(0))) {
                        result.add(s);
                        forRemoval.remove(s);
                        continue;
                    }
                    if( i!=0 &&i!=result.size()-1 ) {
                        if (Character.toLowerCase(result.get(i).charAt(0))==Character.toLowerCase(result.get(i-1).charAt(result.get(i-1).length()-1))
                                &&Character.toLowerCase(result.get(i).charAt(result.get(i).length()-1))==Character.toLowerCase(result.get(i+1).charAt(0))) {
                            result.add(s);
                            forRemoval.remove(s);
                            continue;
                        }
                    }
                }
            }
            if(!iterator.hasNext()) {
                iterator=list.iterator();
            }
            if(bycprzyzwoity >1000)
                break;
            bycprzyzwoity++;
        }
        StringBuilder sb = new StringBuilder();
        for(String koczka : result) {
            sb.append(koczka).append(" ");
        }
        return sb;
    }
}