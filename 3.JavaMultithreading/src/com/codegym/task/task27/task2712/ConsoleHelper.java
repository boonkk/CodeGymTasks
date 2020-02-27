package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        writeMessage("Please select a dish. Type \"exit\" to accept the order.");

        ArrayList<Dish> listOfDishes = new ArrayList<>();
            String s = readString();
            Dish[] availableDishes = Dish.values();
            int listSize=0;

            while (!s.equals("exit")) {
                for (Dish dish : availableDishes) {
                    if(s.equals(dish.name())) {
                        listOfDishes.add(dish);

                    }
                }
                if(listSize==listOfDishes.size())
                    writeMessage("There is no " + s + " in our menu... Fucker.");
                s=readString();

            }
            listSize=listOfDishes.size();
        return listOfDishes;
    }

}
