package com.interfaces.ejemploCar;

public class Bicicleta implements Frenable{

    private int marcha;
    private int velocidad;
    private boolean frenos;

    public Bicicleta(int marcha, int velocidad, boolean frenos) {
        this.marcha = marcha;
        this.velocidad = velocidad;
        this.frenos = frenos;
    }

    public void subirMarcha() {
        marcha++;
    }

    private void bajarMarcha() {
        marcha--;
        if (marcha <= 0) {marcha = 1;}
    }

    public int getVelocidad(){
        return velocidad;
    }

    @Override
    public void frenar() {
        velocidad = velocidad - marcha;

        if (velocidad < 0) {velocidad = 0;}
    }

    @Override
    public void soltarFrenos() {
        velocidad = velocidad * marcha;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "marcha=" + marcha +
                ", velocidad=" + velocidad +
                ", frenos=" + frenos +
                '}';
    }
}
