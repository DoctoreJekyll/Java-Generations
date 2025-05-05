package org.example.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Mascota> mascotas = getMascotas();

        //Nombre
        System.out.println("Ordenando por nombre");
        Collections.sort(mascotas, new NameComparator());
        for (Mascota m : mascotas){
            System.out.println(m);
        }

        //Edad
        System.out.println("Ordenando por edad");
        Collections.sort(mascotas, new AgeComparator());
        for (Mascota m : mascotas){
            System.out.println(m);
        }

        //Breed
        System.out.println("Ordenando por breed");
        Collections.sort(mascotas, new BreedComparator());
        for (Mascota m : mascotas){
            System.out.println(m);
        }

        //Id
        System.out.println("Ordenando por id");
        Collections.sort(mascotas, new IdComparator());
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

}
