package com.codegym.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static{
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }


    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.currentThread().join();
            } catch (InterruptedException e) {

            }
        }
    }

    public static class Thread2 extends Thread {

            @Override
            public void run () {
                while(true) {
                    try {
                        Thread.sleep(1999);
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }

            }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println("Hurray");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }
        }
    }

    public static class Thread4 extends Thread implements Message{

        @Override
        public void showWarning() {
            stop();
        }

        @Override
        public void run() {
            while (isAlive()){

            }
           // Thread.currentThread().interrupt();
        }
    }

    public static class Thread5 extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        @Override
        public void run() {
            try {
                String n = reader.readLine();;
                while (!n.equals("N")) {
                    sum += Integer.parseInt(n);
                    n = reader.readLine();
                }
                System.out.println(sum);
            } catch (IOException e) {

            }
        }


    }
}