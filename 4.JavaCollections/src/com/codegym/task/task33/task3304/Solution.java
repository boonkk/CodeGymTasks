package com.codegym.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Using JSON to convert from one class to another

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);

    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.disable(MapperFeature.USE_ANNOTATIONS);
       // mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        StringWriter writer = new StringWriter();

        mapper.writeValue(writer, one);
        String s = writer.toString();
        System.out.println(s);
        StringReader reader = new StringReader(s);
        ObjectMapper mapperDes = new ObjectMapper();
        mapperDes.disable(MapperFeature.USE_ANNOTATIONS);

        return mapperDes.readValue(reader,resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = First.class, name = "first"),
            @JsonSubTypes.Type(value = Second.class, name = "second")
    })
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    public static class First {
        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = First.class, name = "first"),
            @JsonSubTypes.Type(value = Second.class, name = "second")
    })
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Second {

        public int i;

        public String name;
    }
}