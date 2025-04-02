package com.solid.op.ko;

public class ListCar {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new Car("a");
        cars[1] = new Car("c");
        cars[2] = new Car("d");
    }

    public static void printList(Car[] cars) {
        for (Car car : cars) {
            if (car.getMarca().equals("a")) {
                System.out.println("Vale mucho dinero ayayayayay");
            }
            if (car.getMarca().equals("c")) {
                System.out.println("Vale mucho dinero?");
            }
            if (car.getMarca().equals("d")) {
                System.out.println("Vale poco vale poco");
            }
        }
    }
}
