package com.codegym.task.task33.task3306;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringWriter;

/* 
My first serialization into XML

*/
public class Solution {
    public static void main(String[] args) throws IOException, JAXBException {
        Cat cat = new Cat();
        cat.name = "Missy";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jefferson";

        StringWriter writer = new StringWriter();
        convertToXml(writer, cat);
        convertToXml(writer, dog);
        System.out.println(writer.toString());
        /* Expected output:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<cat>
    <name>Missy</name>
    <age>5</age>
    <weight>3</weight>
</cat>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<dog>
    <name>Killer</name>
    <age>8</age>
    <owner>Bill Jefferson</owner>
</dog>
        */
    }

    public static void convertToXml(StringWriter writer, Object obj) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
    }
    @XmlRootElement
    public static class Pet {
        @XmlElement
        public String name;
    }
    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat extends Pet {
        public int age;
        public int weight;
    }
    @XmlType(name = "dog")
    @XmlRootElement
    public static class Dog extends Pet {
        public int age;
        public String owner;
    }
}