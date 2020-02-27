package com.codegym.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        if(cacheMap.containsKey(key)) {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            return softReference.get();
        } else return null;

        //write your code here
    }

    public AnyObject put(Long key, AnyObject value) {
        if(cacheMap.get(key)!=null) {
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject o = softReference.get();
            softReference.clear();
            return o;
        } else {
            cacheMap.put(key, new SoftReference<>(value));
            return null;
        }

        //write your code here
    }

    public AnyObject remove(Long key) {
        if(cacheMap.get(key)!=null) {
            SoftReference<AnyObject> softReference =cacheMap.get(key);
            AnyObject o = softReference.get();
            cacheMap.remove(key);
            softReference.clear();
            return o;
        } else {
            return null;
        }


        //write your code here
    }
}