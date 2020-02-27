/*
Circular iterator
The Solution class inherits ArrayList.
Properly override the iterator method in the Solution class.
Write your own CircularIterator class inside the Solution class. It will be an iterator for the Solution list.
The iterator must move circularly through all of the elements.
In all other ways, its behavior must be identical to the current iterator.


Requirements:
1. The circular iterator must go to the first element after the last element and so on.
2. The no-argument remove method must remove the current element.
3. If the list is modified incorrectly from different threads, a ConcurrentModificationException must be thrown.
4. The Solution class must be a child of the ArrayList class.
5. The Solution class's iterator() method must return a CircularIterator object.
*/

package com.codegym.task.task37.CircularIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Solution<T> extends ArrayList<T> {
    //todo dopasowac do element data funkcje iteratora i powinno byc mysleze tak hjej
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }

        list.remove(1);
        count =0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    public class CircularIterator implements Iterator<T> {
        Iterator<T> iterator = Solution.super.iterator();
        int cursor = 0;

        @Override
        public boolean hasNext() {
            if (size() == 0)
                return false;
            if (cursor >= size()) {
                iterator = Solution.super.iterator();
                cursor = 0;
            }
            return true;
        }

        @Override
        public T next() {
            cursor++;
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            iterator.forEachRemaining(action);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator();
    }
}