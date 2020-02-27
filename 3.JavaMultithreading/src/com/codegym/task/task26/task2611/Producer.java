package com.codegym.task.task26.task2611;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int index = 1;
        try {
            while (true) {
                map.put(Integer.toString(index), ("Some text for " + index));
                index++;
                Thread.sleep(500);
            }
        }catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}
