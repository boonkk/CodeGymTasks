package com.codegym.task.task17.task1710.argsAsArrayOfStrings;

import com.codegym.task.task17.task1710.Person;

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


        for(String arg:args) {
            if(getOperation(arg).equals("-c")) {
                if (getSex(arg).equals("m")) {
                    allPeople.add(Person.createMale(getName(arg), getDate(arg)));
                } else if (getSex(arg).equals("f")) {
                    allPeople.add(Person.createFemale(getName(arg), getDate(arg)));
                }
                System.out.println(allPeople.size()-1);
            }

            else if(getOperation(arg).equals("-u")) {
                if(getSex(arg).equals("m")) {
                    allPeople.set(getId(arg),Person.createMale(getName(arg),getDate(arg)) );
                } else if(getSex(arg).equals("f")) {
                    allPeople.set(getId(arg),Person.createFemale(getName(arg),getDate(arg)) );
                }
            }

            else if(getOperation(arg).equals("-d")) {
                allPeople.remove(getId(arg));
            }

            else if(getOperation(arg).equals("-i")) {
                int id = getId(arg);
                System.out.println(allPeople.get(id).getName() + " "
                                + allPeople.get(id).getSex() + " "
                                + allPeople.get(id).getBirthDate());
            }
        }
    }

    public static Date getDate(String sequence) {
        String[] parameters = sequence.split(" ");
        try {
            if (parameters[0].equals("-c")) {
                return new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(parameters[3]);
            } else
                return new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH).parse(parameters[4]);
        }catch (ParseException e) {
            return null;
        }
    }


    public static String getName(String sequence) {
        String[] parameters = sequence.split(" ");
        if(parameters[0].equals("-c")) {
            return parameters[1];
        } else return parameters[2];
    }

    public static String getOperation(String sequence) {
        String[] parameters = sequence.split(" ");
        return parameters[0];
    }

    public static String getSex(String sequence) {
        String[] parameters = sequence.split(" ");
        if(parameters[0].equals("-c")) {
            return parameters[2];
        } else return parameters[3];
    }

    public static int getId (String sequence){
        String[] parameters = sequence.split(" ");
        return Integer.parseInt(parameters[1]);
    }
}
