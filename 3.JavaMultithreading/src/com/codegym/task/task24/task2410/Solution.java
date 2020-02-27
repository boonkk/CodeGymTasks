package com.codegym.task.task24.task2410;

import java.util.LinkedList;
import java.util.List;

/* 
Refactoring, anonymous classes

*/
public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();
    private int itemsCount;

    public Iterator getIterator(final String name) {
        return new Iterator() {
            {
                Solution.this.itemsCount++;
                System.out.println(name + " item " + itemsCount);
            }

            @Override
            public Iterator next() {
                return getIterator(name);
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
