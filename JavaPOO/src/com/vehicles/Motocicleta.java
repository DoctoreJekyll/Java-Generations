package com.vehicles;

public class Motocicleta extends Vehiculo{


    private int numAsientos;

    public Motocicleta(int precioDia, String modelo, int numLlantas, int numAsientos) {
        super(precioDia, modelo, numLlantas);
        this.numAsientos = numAsientos;
    }

    @Override
    public void mostrarCaracteristicas() {
        System.out.println("Caracteristicas moto");
        super.mostrarCaracteristicas();
        System.out.println("Numero de asientos: " + numAsientos);
    }

    public void pruebaDelMotor() {
        System.out.println("Testeando motor de la motocicleta");
    }
}
