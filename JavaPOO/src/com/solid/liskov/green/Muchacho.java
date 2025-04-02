package com.solid.liskov.green;

public class Muchacho extends Persona
{

    private Adulto tutor;

    public Muchacho(String nombre, String apellido, Adulto tutor) {
        super(nombre, apellido, null,null);
        this.tutor = tutor;
    }

    public Adulto getTutor() {
        return tutor;
    }

    public void setTutor(Adulto tutor) {
        this.tutor = tutor;
    }

    @Override
    public void pagar() throws Exception {
        tutor.pagar();
    }
}
