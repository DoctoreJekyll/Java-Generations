package com.vehicles;

public class Automovil extends Vehiculo{

    private int numAsientos;
    private int numPuertas;

    public Automovil(int precioDia, String modelo, int numLlantas, int numAsientos, int numPuertas) {
        super(precioDia, modelo, numLlantas);
        this.numAsientos = numAsientos;
        this.numPuertas = numPuertas;
    }

    @Override
    public void mostrarCaracteristicas() {
        System.out.println("Caracteristicas coche");
        super.mostrarCaracteristicas();
        System.out.println("Numero de asientos: " + numAsientos);
        System.out.println("Numero de puertas: " + numPuertas);
    }

    public void pruebaDelMotor()
    {
        System.out.println("Testeando motor del automovil");
    }
}
