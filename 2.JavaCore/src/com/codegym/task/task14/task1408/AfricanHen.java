package com.codegym.task.task14.task1408;

public class AfricanHen extends Hen {
    String continent = "Africa";
    @Override
    String getDescription() {
        return super.getDescription() + " I come from " + continent +  ". I lay " + getMonthlyEggCount() + " eggs a month.";
    }

    @Override
    int getMonthlyEggCount() {
        return 23;
    }
}
