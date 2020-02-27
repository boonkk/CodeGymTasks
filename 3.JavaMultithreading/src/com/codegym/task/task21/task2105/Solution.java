package com.codegym.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Fix the bug. Comparing objects

*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public boolean equals(Object o) {
        if (o==this)
            return true;
        if (!(o instanceof Solution))
            return false;
        if(o==null)
            return false;
        Solution n = (Solution) o;
        return Objects.equals(n.first,first) && Objects.equals(n.last,last);
    }
    public int hashCode() {
        if(first==null || last==null)
            return -1;
        return first.length() *100 + last.length();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
