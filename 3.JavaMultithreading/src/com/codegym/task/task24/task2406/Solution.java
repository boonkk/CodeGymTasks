package com.codegym.task.task24.task2406;

import java.math.BigDecimal;

/* 
Inheriting an inner class

*/
public class Solution {

    public class Building {
        public Building(){

        }
        public  class Hall {
            private BigDecimal area;

            public Hall(BigDecimal area) {
                this.area = area;
            }
        }

        public class Apartment {
            public Apartment() {
            }
        }

    }

    public class ThreeBedroomApt extends Building.Apartment {
        ThreeBedroomApt(Building bldng){
            bldng.super();
        }
    }
    public class BigHall extends Building.Hall  {
        BigHall(Building building, BigDecimal area) {
            building.super(area);
        }
    }




    public static void main(String[] args) {

    }
}
