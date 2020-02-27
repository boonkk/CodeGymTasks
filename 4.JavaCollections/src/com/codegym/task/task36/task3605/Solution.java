package com.codegym.task.task36.task3605;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Using TreeSet

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\marci\\Downloads\\CodeGymTasks\\4.JavaCollections\\src\\com\\codegym\\task\\task36\\task3605\\literki")));
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        TreeSet<Character> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        while(reader.ready()) {
            sb.append(reader.readLine());
        }
        for(int i=0; i<sb.length(); i++) {
            if(Character.isLetter(Character.toLowerCase(sb.charAt(i))))
                treeSet.add(Character.toLowerCase(sb.charAt(i)));
        }

        int i = treeSet.size()>5 ? 5 : treeSet.size();
        Iterator iterator = treeSet.iterator();

        for(int j = 0; j<i ;j++) {
            System.out.print(iterator.next());
        }

    }
}
