package com.codegym.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
Yet another adapter

*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner=fileScanner;
        }
        @Override
        public Person read() throws IOException {
            String line="";
            if(fileScanner.hasNext()){
                line = fileScanner.nextLine();
            }
            String[] arr = line.split(" ");


            StringBuffer buffer = new StringBuffer();
            buffer.append(arr[3]+" ");
            buffer.append(arr[4]+" ");
            buffer.append(arr[5]);
            SimpleDateFormat sdf = new SimpleDateFormat("MM dd yyyy");

            try {
                Date date = sdf.parse(buffer.toString());
                Person andrzej = new Person(arr[2],arr[0],arr[1], date);
                return andrzej;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
