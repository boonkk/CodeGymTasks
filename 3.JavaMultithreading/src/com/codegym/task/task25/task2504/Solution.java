package com.codegym.task.task25.task2504;

import java.lang.Thread.State;

/*
A switch for threads

*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thread : threads) {
            switch (thread.getState()) {
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                    thread.interrupt();
                break;
                case TIMED_WAITING:
                    thread.interrupt();
                break;
                case BLOCKED:
                    thread.interrupt();
                    break;

                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.print(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
