package com.codegym.task.task26.task2603;

import java.util.Comparator;

/*
A convert can easily convert others

*/
public class Solution {

    public static void main(String[] args) {

    }
    public static class CustomizedComparator <T> implements Comparator<T>{
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        public int compare(T o1, T o2) {
            for(Comparator<T> c : comparators) {
                int temp = c.compare(o1,o2);
                if(temp!=0) {
                    return temp;
                }
            }
            return 0;
        }
    }
}
