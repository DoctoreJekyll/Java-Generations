package com.abstracts.examples.ej3;

public class Company {

    public static void main(String[] args) {

        Manager manager = new Manager("Amelia", 3000.45, "43443434S");
        Programmer programmer = new Programmer("Pablo", 1000.45, "2222222F");

        System.out.println("Salary manager total: " + manager.calculateSalary(300));
        System.out.println("Salary programmer total: " + programmer.calculateSalary(50));

        System.out.println("Data and furniture's " + manager.displayInfo("Desk"));
        System.out.println("Data and furniture's " + programmer.displayInfo("PC"));
    }

}
