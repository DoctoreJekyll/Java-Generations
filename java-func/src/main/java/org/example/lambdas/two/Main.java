package org.example.lambdas.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        //lambdaTest();

        List<Mascota> mascotas = getMascotas();

        //Por nombre
        System.out.println( "Ordenando por nombre");
        Collections.sort(mascotas, getComparator("name"));
        printList(mascotas);

        //Por edad
        System.out.println( "Ordenando por edad");
        Collections.sort(mascotas, getComparator("age"));
        printList(mascotas);

        //Por breed
        System.out.println( "Ordenando por breed");
        Collections.sort(mascotas, getComparator("breed"));
        printList(mascotas);

        //Por id
        System.out.println( "Ordenando por id");
        Collections.sort(mascotas, getComparator("id"));
        printList(mascotas);

    }

    private static void printList(List<Mascota> mascotas) {
        for (Mascota m : mascotas){
            System.out.println(m);
        }
    }

    private static void lambdaTest() {
        List<Mascota> mascotas = getMascotas();

        Comparator<Mascota> lambdaComparatorName = (m1, m2) -> m1.getName().compareTo(m2.getName());
        //Nombre
        System.out.println("Ordenando por nombre");
        Collections.sort(mascotas, lambdaComparatorName);
        for (Mascota m : mascotas){
            System.out.println(m);
        }

        Comparator<Mascota> lambdaComparatorAge = (m1, m2) -> m1.getAge() - m2.getAge();
        //Edad
        System.out.println("Ordenando por edad");
        Collections.sort(mascotas,lambdaComparatorAge);
        for (Mascota m : mascotas){
            System.out.println(m);
        }

        Comparator<Mascota> lambdaComparatorBreed = (m1, m2) -> m1.getBreed().compareTo(m2.getBreed());
        //Breed
        System.out.println("Ordenando por breed");
        Collections.sort(mascotas, lambdaComparatorBreed);
        for (Mascota m : mascotas){
            System.out.println(m);
        }

        Comparator<Mascota> lambdaComparatorId = (m1, m2) -> m1.getId() - m2.getId();
        //Id
        System.out.println("Ordenando por id");
        Collections.sort(mascotas, lambdaComparatorId);
        for (Mascota m : mascotas){
            System.out.println(m);
        }
    }

    private static List<Mascota> getMascotas() {
        Mascota mascota = new Mascota(1,"Gato","Gato",3);
        Mascota mascota1 = new Mascota(2,"Perro","Perro",2);
        Mascota mascota2 = new Mascota(3,"Pajaro","Pajaro",1);
        Mascota mascota3 = new Mascota(4,"Caballo","Caballo",4);
        Mascota mascota4 = new Mascota(5,"Perry","Ornitorrinco",5);
        Mascota mascota5 = new Mascota(6,"Capibara","Super Capibara",3);

        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(mascota);
        mascotas.add(mascota1);
        mascotas.add(mascota2);
        mascotas.add(mascota3);
        mascotas.add(mascota4);
        mascotas.add(mascota5);
        return mascotas;
    }

    public static Comparator<Mascota> getComparator(String campo){
        switch (campo){
            case "name":
                return (m1, m2) -> m1.getName().compareTo(m2.getName());
            case "age":
                return (m1, m2) -> m1.getAge() - m2.getAge();
            case "breed":
                return (m1, m2) -> m1.getBreed().compareTo(m2.getBreed());
            case "id":
                return (m1, m2) -> m1.getId() - m2.getId();
            default:
                return null;
        }
    }
}
