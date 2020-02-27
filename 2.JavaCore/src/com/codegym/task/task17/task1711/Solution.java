package com.codegym.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        SimpleDateFormat sdfIn = new SimpleDateFormat("M d yyyy", Locale.ENGLISH);

        switch (args[0]){
            case "-c":
                synchronized (allPeople) {
                    int nameIndex = 1;
                    while (nameIndex < args.length) {
                        if (args[nameIndex+1].equals("m")) {
                            allPeople.add(Person.createMale(args[nameIndex], parseDate(args[nameIndex+2])));
                        } else if (args[nameIndex+1].equals("f")) {
                            allPeople.add(Person.createFemale(args[nameIndex], parseDate(args[nameIndex+2])));
                        }
                        nameIndex+=3;
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    int id = 1;
                    while (id < args.length) {
                        int idIndex = Integer.parseInt(args[id]);
                       // Person person = new Person(args[id+1],parseDate(args[id+3]));
                        allPeople.get(idIndex).setName(args[id+1]);
                        allPeople.get(idIndex).setBirthDate(parseDate(args[id+3]));
                        if (args[id+2].equals("m")){
                            allPeople.get(idIndex).setSex(Sex.MALE);
                        }else if (args[id+2].equals("f")) {
                            allPeople.get(idIndex).setSex(Sex.FEMALE);
                        }
                        id+=4;
                    }
                }
                break;
            case "-d":

                synchronized (allPeople) {
                    int id = 1;
                    while (id<args.length) {
                        int idIndex = Integer.parseInt(args[id]);
                        Person toKill = allPeople.get(idIndex);
                        toKill.setSex(null);
                        toKill.setBirthDate(null);
                        toKill.setName(null);
                        allPeople.set(idIndex, toKill);
                        id++;
                    }

                }
                break;
                //allPeople.set(Integer.parseInt(args[1]),Person.createMale(null, null));
            case "-i":

                synchronized (allPeople) {
                    int id=1;
                    while (id<args.length){
                        int idIndex=Integer.parseInt(args[id]);
                        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
                        String datunia = formatter.format(allPeople.get(idIndex).getBirthDate());



                        if (allPeople.get(idIndex).getSex() == Sex.FEMALE) {
                            System.out.println(allPeople.get(idIndex).getName() + " f " + datunia);
                        } else if (allPeople.get(idIndex).getSex() == Sex.MALE) {
                            System.out.println(allPeople.get(idIndex).getName() + " m " + datunia);
                        }

                        id++;
                    }
                }
                break;
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