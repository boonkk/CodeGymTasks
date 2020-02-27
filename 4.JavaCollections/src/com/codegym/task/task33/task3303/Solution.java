package com.codegym.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Paths;

/* 
Deserializing a JSON object

*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        T result = mapper.readValue(new File(fileName), clazz);
        return result;
    }

    public static void main(String[] args) {

    }
}