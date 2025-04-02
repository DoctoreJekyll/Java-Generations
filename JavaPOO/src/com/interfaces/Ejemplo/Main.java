package com.interfaces.Ejemplo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Tostadora t = new Tostadora("philips", 12);
        Juguera j = new Juguera("tomtom", 500,25.5);

        ArrayList<Preciable> articulos = new ArrayList<>();
        articulos.add(t);
        articulos.add(j);
    }

}
