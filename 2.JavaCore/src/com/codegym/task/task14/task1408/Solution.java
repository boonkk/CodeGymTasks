package com.codegym.task.task14.task1408;

/* 
Chicken factory

*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Continent.AFRICA);
        hen.getMonthlyEggCount();
    }

    static class HenFactory {

        static Hen getHen(String continent) {
            Hen hen = null;
            if(continent.equals("Asia")){
                hen = new AsianHen();
            }
            if(continent.equals("Africa")){
                hen = new AfricanHen();
            }
            if(continent.equals("Europe")){
                hen = new EuropeanHen();
            }
            if(continent.equals("North America")){
                hen = new NorthAmericanHen();
            }
            return hen;
        }
    }


}
