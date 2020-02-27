package com.codegym.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Read online about the median of a sample

*/
public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[6];
        arr[0]=5;
        arr[1]= 10;
        arr[2] = 0;
        arr[3] = -2;
        arr[4] = 9;
        arr[5] = 13;

        sort(arr);

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        double median;
        if(array.length%2==0)
            median = ((double)array[array.length/2]+(double)array[array.length/2-1])/2;
        else
            median = array[array.length/2];

        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(median-o1)==Math.abs(median-o2))
                    if(o1>o2)
                        return 1;
                    else return -1;
                if(Math.abs(median-o1)<Math.abs(median-o2))
                    return -1;
                else return 1;
            }
        };
        Arrays.sort(array,compare);
        return array;
    }
}
