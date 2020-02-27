package com.codegym.task.task37.myHashSet;


import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class MyHashSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public MyHashSet() {
        this.map = new HashMap<>();
    }

    public MyHashSet(Collection<? extends E> collection) {
        int size = Math.max(16,(int)(collection.size()/.75f+1));
        this.map = new HashMap<>(size);
        this.addAll(collection);
    }

    @Override
    public boolean add(Object e){
        if (map.containsKey(e)){
            return false;
        }else{
            map.put((E)e,PRESENT);
            return true;
        }
    }
    @Override
    public Iterator<E> iterator () {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public Object clone() throws InternalException {
        try {
            Object clone = super.clone();
            Object temp =  map.clone();  // literally a useless line
            return clone;
        } catch (Exception e) {
            throw new InternalError("Cloning exception", e);
        }
    }

    private void writeObject(java.io.ObjectOutputStream s) throws IOException {

        s.defaultWriteObject();

        s.writeObject(map.size());
        for(E e:map.keySet()){
            s.writeObject(e);
        }
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }

    private void readObject(java.io.ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        int size = (int)s.readObject();
        Set<E> set = new HashSet<>();
        for(int i =0;i<size;i++){
            set.add((E)s.readObject());
        }
        int capacity = (int)s.readObject();
        float loadFactor = (float)s.readObject();
        map = new HashMap<>(capacity,loadFactor);
        for(E e:set){
            map.put(e,PRESENT);
        }
    }
}
