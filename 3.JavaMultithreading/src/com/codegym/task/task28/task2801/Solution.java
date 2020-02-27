package com.codegym.task.task28.task2801;

/* 
Mastering switch

*/
public class Solution {
    public static enum E1 {A, B, C, Y}

    public static enum E2 {D, E, F}

    public static enum E3 {D, E, F}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);
        Solution.switchTest(E3.D);
        Solution.switchTest(E2.D);
        /* Output
        it's E1.C
        undefined
        it's E2.D
         */
    }

    public static void switchTest(Enum obj) {
        String name = obj.getClass().getSimpleName();
        switch (name) {
            case "E1":
                System.out.println(String.format("it's %s.%s", name, obj.name()));
                break;
            case "E2":
                System.out.println(String.format("it's %s.%s", name, obj.name()));
                break;
            default:
                System.out.println("undefined");
                break;

        }
    }
}
