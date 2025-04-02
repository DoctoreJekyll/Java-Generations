package com.interfaces.figuras;

public class Triangle implements Shape{

    private double base;
    private double large;

    private double a;

    public Triangle(double base, double large) {
        this.base = base;
        this.large = large;
    }


    @Override
    public void getArea() {
        a = (base * large)/2;

        System.out.println("Area: " + a);
    }
}
