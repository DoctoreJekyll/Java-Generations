package com.interfaces.ejemploCar;

public class Coche implements Frenable {

    private boolean frenos;
    private int velocidad;

    public Coche(boolean frenos, int velocidad) {
        this.frenos = frenos;
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public void frenar() {
        velocidad = velocidad - 1;
    }

    @Override
    public void soltarFrenos() {
        velocidad = velocidad + 10;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "frenos=" + frenos +
                ", velocidad=" + velocidad +
                '}';
    }
}
