package com.codegym.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List <Horse> horses;

    public Hippodrome(List list) {
        horses = list;
    }
    public List<Horse> getHorses() {
        return horses;
    }


    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> hss = new ArrayList<>();
        hss.add(new Horse("Jack",3,0));
        hss.add(new Horse("Frantisek",3,0));
        hss.add(new Horse("Cymbał",3,0));
        game = new Hippodrome(hss);
        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for(int i=0;i<100;i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for(Horse h : horses) {
            h.move();
        }
    }
    public void print(){

        for(Horse h : horses) {
            h.print();
        }
        for(int i=0;i<10;i++)
            System.out.println("");
    }
    public Horse getWinner(){
        Horse h = horses.get(0);
        for(Horse hose : horses)
            if(hose.getDistance()>h.getDistance())
                h=hose;

        return h;
    }
    public void printWinner() {
        System.out.println("The winner is " + getWinner().getName() + "!");
    }
}
