package com.codegym.task.task30.task3001;

import java.math.BigInteger;

/*
Numeral system converter

*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    // 110 expected

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    // 3337 expected

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    // abcdefabcdef expected
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        BigInteger temp = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());

        return new Number(expectedNumberSystem, temp.toString(expectedNumberSystem.getNumberSystemIntValue()));
    }
}