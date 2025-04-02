package com.solid.liskov.green;

public class Adulto extends Persona{
    public Adulto(String nombre, String apellido, String dni, String tarjeta) {
        super(nombre, apellido, dni, tarjeta);
    }

    @Override
    public void pagar() throws Exception {
        super.pagar();
        System.out.println("Adulto pagado");
    }
}
