package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.kitchen.Waiter;


public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet1 = new Tablet(1);
        Cook cook = new Cook("Rychu");
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        tablet1.addObserver(cook);
        tablet1.createOrder();
        tablet1.createOrder();
        tablet1.createOrder();
        tablet1.createOrder();






    }
}
