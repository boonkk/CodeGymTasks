package com.codegym.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertibleUtil {

    public static Map convert(List<? extends Convertible> list) {
        Map result = new HashMap();
        for(Convertible element : list ) {
            result.put(element.getKey(),element);
        }
        return result;
    }
}