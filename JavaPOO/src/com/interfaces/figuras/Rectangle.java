package com.interfaces.figuras;

public class Rectangle implements Shape{

    private double base;
    private double side;

    private double a;

    public Rectangle(double base, double side){
        this.base = base;
        this.side = side;
    }

    @Override
    public void getArea() {
        a = base * side;

        System.out.println("Area: " + a);
    }
}
