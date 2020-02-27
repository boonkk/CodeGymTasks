package com.codegym.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Motorbike.class, name = ".Motorbike"),
        @JsonSubTypes.Type(value = RacingBike.class, name = "com.codegym.task.task33.task3305.RaceBike"),
        @JsonSubTypes.Type(value = Car.class, name = "com.codegym.task.task33.task3305.Car"),
        @JsonSubTypes.Type(value = ParkingLot.class, name = ".ParkingLot")
})
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}