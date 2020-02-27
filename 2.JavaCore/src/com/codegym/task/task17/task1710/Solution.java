package com.codegym.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD

*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        if (args[0].equals("-c")) {
            if (args[2].equals("m")) {
                allPeople.add(Person.createMale(args[1], parseDate(args[3])));
            } else if (args[2].equals("f")) {
                allPeople.add(Person.createFemale(args[1], parseDate(args[3])));
            }
            System.out.println(allPeople.size() - 1);
        }

        if (args[0].equals("-u")) {
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(parseDate(args[4]));
            if (args[3].equals("m")){
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
            }else if (args[3].equals("f")) {
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
            }
        }
        if (args[0].equals("-i")) {
            SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
            String datunia = formatter.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate());
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " ");

                if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE)) {
                    System.out.print("f" + " ");
                } else if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)) {
                    System.out.print("m" + " ");
                }
                System.out.print(datunia);
        }
        if (args[0].equals("-d")) {
            Person toKill = allPeople.get(Integer.parseInt(args[1]));
            toKill.setSex(null);
            toKill.setBirthDate(null);
            toKill.setName(null);
            //allPeople.set(Integer.parseInt(args[1]),Person.createMale(null, null));
        }
    }

    public static Date parseDate (String textDate) {

        try {
            return new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(textDate);
        } catch (Exception e) {
            System.out.println("Wrong data.");
            return null;
        }

    }
}
