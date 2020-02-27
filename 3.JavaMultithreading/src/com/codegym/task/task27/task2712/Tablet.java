package com.codegym.task.task27.task2712;


import com.codegym.task.task27.task2712.ad.AdvertisementManager;
import com.codegym.task.task27.task2712.ad.NoVideoAvailableException;
import com.codegym.task.task27.task2712.kitchen.Order;



import java.io.IOException;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    final int number;
    public static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        try {
            Order order = new Order(this);
            if(order.isEmpty())
                return null;
            setChanged();
            notifyObservers(order);
            try {
                new AdvertisementManager(order.getTotalCookingTime()).processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO,"No video is available for the following order: " + order);
            }
            return order;
        } catch (IOException e) {
            logger.severe("The console is unavailable.");
            return null;
        }

    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }


}
