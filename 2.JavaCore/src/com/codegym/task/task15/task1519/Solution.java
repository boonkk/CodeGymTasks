package com.codegym.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Different methods for different types

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = reader.readLine();
        try{

            while(true) {

                if (data.equals("exit")){
                    break;
                }else if (data.contains(".")&&tryParseDouble(data)) {
                    print(Double.parseDouble(data));
                }else if(tryParse(data)) {
                    int i = Integer.parseInt(data);
                    if (i <= 0 || i>=128){
                    print(i);
                    } else{
                    print((short)i);
                    }
                }else {print (data);}
                data = reader.readLine();
            }

        }catch (NumberFormatException e){
            print (data);

        }
    }
    public static boolean tryParse(String data){
        try{
            Integer.parseInt(data);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static boolean tryParseDouble (String data) {
        try {
            Double.parseDouble(data);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public static void print(Double value) {
        System.out.println("This is a Double. Value: " + value);
    }

    public static void print(String value) {
        System.out.println("This is a String. Value: " + value);
    }

    public static void print(short value) {
        System.out.println("This is a short. Value: " + value);
    }

    public static void print(Integer value) {
        System.out.println("This is an Integer. Value: " + value);
    }
}
