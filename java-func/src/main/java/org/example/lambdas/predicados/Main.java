package org.example.lambdas.predicados;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        System.out.println(esPar.test(10));
    }

    public static Predicate<Integer> esPar = (n) -> n % 2 == 0;

}
