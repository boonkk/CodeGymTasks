package com.codegym.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Mastering the static block

*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String flyingThing = reader.readLine();
            if (flyingThing.equals("helicopter")){
                result = new Helicopter();
            }
            if (flyingThing.equals("plane")){
                flyingThing = reader.readLine();
                result = new Plane(Integer.parseInt(flyingThing));
            }
            reader.close();
        } catch (Exception e) {

        }
    }
}
