package com.vehicles;

public class Autobus extends Vehiculo{

    private int numAsientos;
    private int numPuertas;
    private int numVentanas;

    public Autobus(int precioDia, String modelo, int numLlantas, int numVentanas, int numAsientos, int numPuertas) {
        super(precioDia, modelo, numLlantas);
        this.numAsientos = numAsientos;
        this.numPuertas = numPuertas;
        this.numVentanas = numVentanas;
    }

    @Override
    public void mostrarCaracteristicas() {
        System.out.println("Caracteristicas bus");
        super.mostrarCaracteristicas();
        System.out.println("Caracteristica del bus: " + numAsientos + " " + numPuertas+ " " + numVentanas);
    }

    public void pruebaDelMotor() {
        System.out.println("Testeando motor del bus");
    }
}
