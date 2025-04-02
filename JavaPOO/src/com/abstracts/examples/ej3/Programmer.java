package com.abstracts.examples.ej3;

public class Programmer extends Employee
{
    public Programmer(String name, double salary, String dni) {
        super(name, salary, dni);
    }

    @Override
    public double calculateSalary(double extras) {
        setSalary(getSalary() + extras);
        return getSalary();
    }

    @Override
    public String displayInfo(String equipment) {
        return toString() + "Programmers need: " + equipment;
    }
}
