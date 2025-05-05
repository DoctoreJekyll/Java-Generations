package org.example.lambdas;

public class Main {

    public static void main(String[] args) {
        ICalculable calculable = (a, b) -> a + b;
        ICalculable resta = (a, b) -> a - b;
        System.out.println(calculable.calculable(10, 20));
        System.out.println(resta.calculable(10, 20));
    }

}
