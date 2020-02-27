package com.codegym.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
A list and some threads

*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        SpecialThread a1 = new SpecialThread();
        SpecialThread a2 = new SpecialThread();
        SpecialThread a3 = new SpecialThread();
        SpecialThread a4 = new SpecialThread();
        SpecialThread a5 = new SpecialThread();

        Thread b1 = new Thread(a1);
        Thread b2 = new Thread(a2);
        Thread b3 = new Thread(a3);
        Thread b4 = new Thread(a4);
        Thread b5 = new Thread(a5);
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("This is the run method inside SpecialThread");
        }
    }
}
