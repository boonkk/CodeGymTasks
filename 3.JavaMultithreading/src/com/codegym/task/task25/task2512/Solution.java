package com.codegym.task.task25.task2512;

/* 
Charting our own course

*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printException(e);
    }

    public void printException(Throwable e) {
        if( e.getCause() != null )
            printException(e.getCause());
        System.out.println(e.fillInStackTrace());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread = new Thread();
        solution.uncaughtException(thread, new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
