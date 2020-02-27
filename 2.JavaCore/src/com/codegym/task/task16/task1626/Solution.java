package com.codegym.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Decrease").start();
        new Thread(new CountUpRunnable(), "Increase").start();
    }

    public static class CountUpRunnable implements Runnable {
        public CountUpRunnable() {
        }

        @Override
        public void run() {
            try {
                for (int i=1; i<=number; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }
        //write your code here
    }


    public static class CountdownRunnable implements Runnable {
        private int countdownIndex = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countdownIndex -= 1;
                    if (countdownIndex == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countdownIndex;
        }
    }
}
