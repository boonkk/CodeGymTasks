package com.codegym.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
John Johnson

*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] arr = line.split(" ");
            StringBuffer sb = new StringBuffer();
            StringBuffer sbd = new StringBuffer();
            for (int i=0; i<arr.length-3;i++)
                sb.append(arr[i] + " ");

            for (int i=arr.length-3; i<arr.length;i++)
                sbd.append(arr[i] + " ");


            PEOPLE.add(new Person(sb.toString().trim(),new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(sbd.toString())));
        }
        reader.close();
    }
}
