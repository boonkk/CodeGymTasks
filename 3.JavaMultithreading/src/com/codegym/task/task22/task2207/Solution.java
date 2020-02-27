package com.codegym.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* 
Inverted words

*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = "C:\\Users\\marci\\Downloads\\CodeGymTasks\\3.JavaMultithreading\\src\\com\\codegym\\task\\task22\\task2207\\dupa";
        String fileName = reader.readLine();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF8"));
        List<String> fileContents = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] array = line.split(" ");
            fileContents.addAll(Arrays.asList(array));
        }
        for(int i=0;i<fileContents.size();i++) {
            if(indexes.contains(i))
                continue;
            indexes.add(i);
            StringBuilder sb = new StringBuilder();
            sb.append(fileContents.get(i));
            sb.reverse();
            for(int j=0; j<fileContents.size(); j++) {
                if(indexes.contains(j))
                    continue;

                if(sb.toString().equals(fileContents.get(j)))
                {
                    Pair pair = new Pair();
                    pair.first=fileContents.get(i);
                    pair.second = sb.toString();

                    result.add(pair);
                    indexes.add(j);
                    break;
                }
            }
        }



//        for(Pair p : result) {
//            System.out.println(p.first + " " + p.second);
//        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }

}