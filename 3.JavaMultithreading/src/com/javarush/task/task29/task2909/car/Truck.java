package com.javarush.task.task29.task2909.car;
//10..1
public class Truck  extends Car{

    public Truck(int numberOfPassengers) {
        super(numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
