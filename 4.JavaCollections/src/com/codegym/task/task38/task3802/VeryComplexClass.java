package com.codegym.task.task38.task3802;

/* 
Checked exceptions

*/


import java.text.SimpleDateFormat;
import java.util.Date;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("MMMMM dd yyyy");
        Date date = df.parse("1234 abcd");
    }

    public static void main(String[] args) {

    }
}
