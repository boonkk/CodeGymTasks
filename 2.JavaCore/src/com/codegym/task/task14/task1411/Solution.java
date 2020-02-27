package com.codegym.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, loser, coder and programmer

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();

        while(true)
        {
            if (key.equals("user")) {
                person = new Person.User();
            }else if (key.equals("loser")){
                person = new Person.Loser();
            }else if (key.equals("programmer")){
                person = new Person.Programmer();
            }else if (key.equals("coder")){
                person = new Person.Coder();
            }else break;

            doWork(person); // Call doWork
            key = reader.readLine();
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.Coder){
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Programmer){
            ((Person.Programmer) person).enjoy();
        }
        if (person instanceof Person.Loser){
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.User){
            ((Person.User) person).live();

        }
    }
}
