package com.solid.liskov.ko;

public class Muchacho extends Persona
{
    public Muchacho(String nombre, String apellido) {
        super(nombre, apellido, null, null);
    }

    @Override
    public void pagar() {
        throw new RuntimeException("Not supported yet");
    }
}
