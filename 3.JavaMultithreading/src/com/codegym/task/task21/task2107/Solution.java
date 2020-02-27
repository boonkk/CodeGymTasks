package com.codegym.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Deep cloning of a map

*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
            try {
                clone = (Solution) solution.clone();
                System.out.println(solution);
                System.out.println(clone);

                System.out.println(solution.users);
                System.out.println(clone.users);
            }catch (CloneNotSupportedException e) {}
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Map<String,User> result = new LinkedHashMap<>();
        for(Map.Entry<String,User> user : users.entrySet()) {
            result.put(user.getKey(),new User(user.getValue().age,user.getValue().name));
        }
        Solution sol = new Solution();
        sol.users=result;
        return sol;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public int hashCode() {
            if(this.age<0 || this.name == null)
                return -1;
            return this.age*31 + this.name.length();
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof User))
                return false;
            if(obj==null)
                return false;
            if(obj==this)
                return true;
            User u = (User) obj;
            return Objects.equals(u.age, age) && Objects.equals(u.name,name);
        }
    }
}
