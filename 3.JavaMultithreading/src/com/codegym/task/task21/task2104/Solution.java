package com.codegym.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode

*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Solution)) {
            return false;
        }
        Solution s = (Solution)o;
        return Objects.equals(first,s.first) && Objects.equals(last, s.last);
    }

    public int hashCode() {
        if(first==null || last==null)
            return -1;
        return first.length() *100 + last.length();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
