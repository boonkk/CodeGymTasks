package com.codegym.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        try{
            while(!isValuePresent)
                Thread.currentThread().wait();

        } catch (Exception e) {

        }
        notifyAll();
        System.out.println("Got: " + value);
        isValuePresent = false;
        return value;
    }

    public synchronized void put(int value) {
        try {
            while (isValuePresent)
                Thread.currentThread().wait();

        } catch (Exception e) {

        }
        notifyAll();
        isValuePresent = true;
        this.value = value;
        System.out.println("Put: " + value);
    }
}
