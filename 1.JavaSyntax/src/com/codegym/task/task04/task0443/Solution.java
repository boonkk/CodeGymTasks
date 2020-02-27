package com.codegym.task.task04.task0443;


/* 
A name is a name

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String yyyy = reader.readLine();
        String mm = reader.readLine();
        String dd = reader.readLine();

        System.out.println("My name is " + name + ".");
        System.out.println("I was born on " + mm + "/" + dd + "/"+ yyyy);
    }
}
