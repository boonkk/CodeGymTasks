package com.codegym.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Reinforce the singleton pattern

*/

public class Solution {
    public static void main(String[] args) {
    readKeyFromConsoleAndInitPlanet();
    }

    public static Planet thePlanet;

    // Add static block here

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        String line = reader.readLine();
        if (line.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();
        }
        else if (line.equals(Planet.MOON)){
                thePlanet = Moon.getInstance();
        }
        else if (line.equals(Planet.SUN)){
                thePlanet = Sun.getInstance();
        } else {thePlanet = null;}
        }catch (IOException e){

        }

    }
}
