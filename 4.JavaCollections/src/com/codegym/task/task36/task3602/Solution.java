package com.codegym.task.task36.task3602;


import java.lang.reflect.Field;
import java.util.Collections;


/* 
Find the class by its description

*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }


        public static Class getExpectedClass() {
            try {
                Class cls = Collections.class;
                Class[] classes = cls.getDeclaredClasses();

                Field[] fields = cls.getDeclaredFields();
//                for(Field f : fields) {
//                    System.out.println(f.getName() + " " +  f.getModifiers());
//                }
            } catch (Exception e) {
            }
            return Collections.EMPTY_LIST.getClass();

        }

}
