package com.interfaces.ejemploCar;

public class Main {

    public static void main(String[] args) {
        Coche coche = new Coche(true, 2);
        Bicicleta bici = new Bicicleta(5,5,true);

        bici.soltarFrenos();
        bici.soltarFrenos();
        bici.frenar();
        System.out.println(bici.getVelocidad());


        coche.soltarFrenos();
        coche.soltarFrenos();
        coche.frenar();
        System.out.println(coche.getVelocidad());
    }

}
