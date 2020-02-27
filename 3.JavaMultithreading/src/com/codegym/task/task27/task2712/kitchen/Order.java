package com.codegym.task.task27.task2712.kitchen;

import com.codegym.task.task27.task2712.ConsoleHelper;
import com.codegym.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if(dishes.size()==0)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append("Your order: [");
        for (Dish dish : dishes) {
            sb.append(dish.name()).append(", ");
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append("] ");
        sb.append("from ").append(tablet.toString());
        sb.append(", cooking time ").append(getTotalCookingTime()).append(" min");
        return sb.toString();
    }
    public int getTotalCookingTime() {
        int totalCookingTime=0;
        for(Dish dish : dishes) {
            totalCookingTime+=dish.getDuration();
        }
        return totalCookingTime;
    }
    public boolean isEmpty() {
        return(dishes.isEmpty());
    }
}
