package com.codegym.task.task18.task1823;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Threads and bytes

*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("exit")) { //does it work?
            ReadThread a = new ReadThread(line);
            a.start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private FileInputStream fis;
        private String fileName;
        public ReadThread(String fileName) throws IOException{
            fis = new FileInputStream(fileName);
            this.fileName = fileName;


        }

        @Override
        public void run(){
            int maxByteOc = 0;
            int current;
            HashMap<Integer,Integer> map = new HashMap<>();
            try {
                while(fis.available()>0){
                    current = fis.read();
                    if(map.containsKey(current)){
                        map.replace(current,map.get(current)+1);
                    } else map.put(current,1);
                }
                for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                    if (entry.getValue()>maxByteOc) {
                        maxByteOc=entry.getValue();
                        resultMap.put(fileName,entry.getKey());
                    }
                }
                fis.close();
            } catch (IOException e) {
            }



        }
    }
}
