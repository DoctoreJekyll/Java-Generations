package org.example.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {
        numbersList().stream().map(n -> n + 5).forEach(System.out::println);


    }

    public static void exampleWithJ()
    {
        List<String> names = namesList();
        List<String> namesWithJ = names.stream().filter(name -> name.startsWith("J")).collect(Collectors.toList());

        System.out.println(namesWithJ);
    }

    public static void exampleOrders()
    {
        actorsList().stream().sorted().forEach(System.out::println);
        System.out.println("-");
        actorsList().stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }


    public static List<String> namesList()
    {
        return Arrays.asList("Jose", "Roberto", "Jaime", "Carlos", "Mario", "Anastasia", "Daniel", "Bonifacio", "Miguel");
    }

    public static List<String> actorsList()
    {
        List<String> lista = Arrays.asList("Mitchum", "Delon", "Belmondo", "Affleck", "De Niro", "Al Pacino", "Daniel Craig", "Torrente", "Nuria Espert", "Wayne", "Darin", "Depardieu");
        return lista;
    }

    public static List<Integer> numbersList(){
        List<Integer> numerosInt = Arrays.asList(1, 2, 3, 7, 8, 32, 55, 87, 11, 15);
        return numerosInt;
    }

}
