package java8Feature.com.java8.defaultstaticinterfacemethods.impl;

import com.ramesh.java8.defaultstaticinterfacemethods.interfaces.Vehicle;

public class Car implements Vehicle {

    private final String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "The car is speeding up.";
    }

    @Override
    public String slowDown() {
        return "The car is slowing down.";
    }
}