package com.codegym.task.task25.task2510;

/* 
Wait and see

*/
public class Solution extends Thread {

    public Solution() {
        Thread t = this;
        t.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    System.out.println("Can't keep running");
                    return;
                }
                if (e instanceof Exception) {
                    System.out.println("Needs handling");
                    return;
                }
                if (e instanceof Throwable)
                    System.out.println("Wait and see");
            }
        });
    }

    public static void main(String[] args) {
    }
}
