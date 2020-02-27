 package com.codegym.task.task20.task2003;

import java.io.*;
import java.util.*;

 /*
 Introducing properties

 */
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fis = new FileInputStream(fileName);
        load(fis);
        fis.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();
        for(Map.Entry<String, String> entry : properties.entrySet()) {
            props.put(entry.getKey(),entry.getValue());
        }
        props.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties props = new Properties();
        props.load(inputStream);

        Set keys = props.keySet();
        Iterator iterator = keys.iterator();

        String key;
        String value;

        while(iterator.hasNext()) {
            key = (String) iterator.next();
            value = props.getProperty(key);
            properties.put(key,value);
        }
    }

    public static void main(String[] args) {

    }
}
