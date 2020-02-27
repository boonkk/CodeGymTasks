package com.codegym.task.task17.task1711.dgdfg;

import com.codegym.task.task17.task1711.Person;
import com.codegym.task.task17.task1711.Sex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2

*/

public class Solutiondsds {
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
                    for (int i=0;i<(args.length-1)/3-1;i++) {
                        if (args[3*i+2].equals("m")) {
                            allPeople.add(Person.createMale(args[3*i+1], parseDate(args[3*i+3])));
                        } else if (args[3*i+2].equals("f")) {
                            allPeople.add(Person.createFemale(args[3*i+1], parseDate(args[3*i+3])));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i=0;i<(args.length-1)/4-1;i+=6) {
                        allPeople.get(Integer.parseInt(args[i+1])).setName(args[i+2]);
                        try {
                            allPeople.get(Integer.parseInt(args[i+1])).setBirthDate(sdfIn.parse
                                    (args[i + 3] + " " + args[i+4] + " " + args[i+5]));
                        } catch (ParseException e) {

                        }
                        if (args[i+3].equals("m")){
                            allPeople.get(Integer.parseInt(args[i+1])).setSex(Sex.MALE);
                        }else if (args[i+3].equals("f")) {
                            allPeople.get(Integer.parseInt(args[i+1])).setSex(Sex.FEMALE);
                        }
                    }
                }
            case "-d":

                synchronized (allPeople) {
                    for (int i=0;i<args.length-2;i++) {
                        Person toKill = allPeople.get(Integer.parseInt(args[i+1]));
                        toKill.setSex(null);
                        toKill.setBirthDate(null);
                        toKill.setName(null);
                        allPeople.set(Integer.parseInt(args[i+1]), toKill);
                    }
                    break;
                }
                //allPeople.set(Integer.parseInt(args[1]),Person.createMale(null, null));
            case "-i":

                synchronized (allPeople) {
                    for (int i=0;i<args.length-2;i++) {
                        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
                        String datunia = formatter.format(allPeople.get(Integer.parseInt(args[i+1])).getBirthDate());
                        System.out.println(allPeople.get(Integer.parseInt(args[i+1])).getName() + " ");

                        if (allPeople.get(Integer.parseInt(args[i+1])).getSex().equals(Sex.FEMALE)) {
                            System.out.print("f" + " ");
                        } else if (allPeople.get(Integer.parseInt(args[i+1])).getSex().equals(Sex.MALE)) {
                            System.out.print("m" + " ");
                        }
                        System.out.print(datunia);
                    }
                }
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