package com.codegym.task.task14.task1419;

import java.nio.channels.NoConnectionPendingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Exception invasion

*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   // The first exception
        //1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new NullPointerException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new NoSuchMethodException());
        exceptions.add(new NoConnectionPendingException());
        exceptions.add(new IllegalThreadStateException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new IllegalAccessException());
        exceptions.add(new InstantiationException());

    }
}
