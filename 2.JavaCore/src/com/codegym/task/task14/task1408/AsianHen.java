package com.codegym.task.task14.task1408;

public class AsianHen extends Hen {
    String continent = "Asia";
    @Override
    String getDescription() {
        return super.getDescription() + " I come from " + continent +  ". I lay " + getMonthlyEggCount() + " eggs a month.";
    }

    @Override
    int getMonthlyEggCount() {
        return 34;
    }
}
