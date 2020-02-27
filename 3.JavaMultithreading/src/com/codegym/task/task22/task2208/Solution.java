package com.codegym.task.task22.task2208;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Build a WHERE query

*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();

        map.put("name",null);
        map.put("country",null);
        map.put("city",null);
        map.put("age",null);
        System.out.print(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        int count = 0;
        if( Collections.frequency(params.values(), null) == params.size()){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<String,String> entry : params.entrySet()) {
            if(entry.getValue()!=null)
            sb.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
        }

        sb.delete(sb.length()-1-4,sb.length()-1);
        return sb.toString().trim();
    }
}
