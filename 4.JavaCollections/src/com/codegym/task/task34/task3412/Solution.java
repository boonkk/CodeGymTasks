package com.codegym.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Adding logging to a class

*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug("Error");
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("Error");
        value -= 133;

        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("Error");
        } else {
            value1 = (int) value;
            logger.debug("Error");
        }
    }

    public void printString() {
        logger.trace("Error");
        if (value2 != null) {
            System.out.println(value2.length());

        }

    }

    public void printDateAsLong() {
        logger.trace("Error");
        if (value3 != null) {
            System.out.println(value3.getTime());

        }

    }

    public void divide(int number1, int number2) {
        logger.trace("Error");
        try {
            System.out.println(number1 / number2);

        } catch (ArithmeticException e) {

            logger.error("Error",e);
        }
    }

    public void setValue1(int value1) {
        logger.debug("Error");
        this.value1 = value1;
    }

    public void setValue2(String value2) {
        logger.debug("Error");
        this.value2 = value2;
    }

    public void setValue3(Date value3) {
        logger.debug("Error");
        this.value3 = value3;
    }
}
