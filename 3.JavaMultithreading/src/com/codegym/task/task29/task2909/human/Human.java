package com.codegym.task.task29.task2909.human;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;


    protected Size size;


    private List<Human> children = new ArrayList<>();


    private BloodType bloodType;

    public void live(){}
    public Human(String name, int age) {
        this.age=age;
        this.name=name;
    }
    public void setBloodType(BloodType bloodType) {
       this.bloodType=bloodType;
    }

    public BloodType getBloodType() {
        return bloodType;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void printData() {
        System.out.println(getPosition() + ": "  + name);
    }

    public String getPosition() {
        return "Person";
    }

    public int getId() {
        return id;
    }



    public void printSize() {
        System.out.println("Height: " + size.height + " Weight: " + size.weight);
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child) {
        children.add(child);
    }
    public void removeChild (Human child) {
        children.remove(child);
    }

    public class Size{
        public int weight;
        public int height;
    }
}