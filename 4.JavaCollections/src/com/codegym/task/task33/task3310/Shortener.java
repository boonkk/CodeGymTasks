package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        if(!storageStrategy.containsValue(string)) {
            lastId++;
            storageStrategy.put(lastId,string);

        }
        return storageStrategy.getKey(string);
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}