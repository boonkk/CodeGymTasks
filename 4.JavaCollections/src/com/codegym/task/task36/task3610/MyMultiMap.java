package com.codegym.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size=0;
        for(Map.Entry<K,List<V>> entry : map.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        if(map.containsKey(key) && map.get(key).size()<repeatCount) {
            V val = map.get(key).get(map.get(key).size()-1);
            map.get(key).add(value);
            return val;
        } else if (map.containsKey(key) && map.get(key).size()==repeatCount) {
            V val = map.get(key).get(map.get(key).size()-1);
            map.get(key).remove(0);
            map.get(key).add(value);
            return val;
        } else if (!map.containsKey(key)) {
            ArrayList<V> arrayList = new ArrayList<>();
            arrayList.add(value);
            map.put(key,arrayList);
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        if (map.containsKey(key)) {
            if(map.get(key).size()>1){
                V value=map.get(key).get(0);
                map.get(key).remove(0);
                return value;
            }
            else {
                V value=map.get(key).get(0);
                map.remove(key);
                return value;
            }
        }
        else return null;

    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        ArrayList<V> result = new ArrayList<>();
        for(Map.Entry<K,List<V>> entry : map.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for(Map.Entry<K,List<V>> entry : map.entrySet()) {
            for(V val : entry.getValue()) {
                if (val.equals(value))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}