package com.codegym.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Random;

/* 
Password generator

*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        try {
            String password = newPassword();
            boolean upper=false;
            boolean lower=false;
            boolean digit=false;

            char[] passChars = password.toCharArray();

            while (true) {
                for(int i=0;i<8;i++) {
                    if( Character.isLowerCase(passChars[i]))
                        lower=true;
                    if (Character.isUpperCase(passChars[i]))
                        upper=true;
                    if (Character.isDigit(passChars[i]))
                        digit=true;
                }
                if(upper && lower && digit)
                    break;
                else {
                    password = newPassword();
                    passChars = password.toCharArray();
                    upper = false;
                    lower = false;
                    digit = false;
                }
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos.write(password.getBytes());
            return baos;

        } catch (Exception e) {
            return new ByteArrayOutputStream();
        }
    }

    public static String newPassword() {
        final char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(chars[random.nextInt(chars.length)]);
        }

        return sb.toString();
    }
}