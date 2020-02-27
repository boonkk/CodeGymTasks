package com.codegym.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*
Comments inside XML

*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //marshaller.setProperty(tagName, comment);
        marshaller.marshal(obj, writer);
        String result = writer.toString();
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new StringReader(result));
        String s;
        while ((s = reader.readLine()) !=null) {

            if(s!=null && s.contains(tagName) && !s.toLowerCase().contains("cdata")) {
                sb.append("<!--").append(comment).append("-->").append("\n");
                sb.append(s);
            } else {
                sb.append(s);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Cat cat = new Cat();
        System.out.print(toXmlWithComment(cat,"age","pupsko"));
    }
}