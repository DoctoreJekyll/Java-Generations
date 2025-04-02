package com.abstracts.examples.ej3;

public abstract class Employee
{
    private String name;
    private double salary;
    private String dni;

    public Employee(String name, double salary, String dni) {
        this.name = name;
        this.salary = salary;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dni='" + dni + '\'' +
                '}';
    }

    public abstract double calculateSalary(double extras);
    public abstract String displayInfo(String equipment);
}
