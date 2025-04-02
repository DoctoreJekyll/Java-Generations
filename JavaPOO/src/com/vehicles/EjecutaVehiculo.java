package com.vehicles;

public class EjecutaVehiculo {
    public static void main(String[] args) {
        Automovil automovil = new Automovil(100, "golf",4,4,4);
        Motocicleta motocicleta = new Motocicleta(1000, "toyota",2,1);
        Autobus autobus = new Autobus(2000,"Renault",8,20,30,3);

        automovil.mostrarCaracteristicas();
        motocicleta.mostrarCaracteristicas();
        autobus.mostrarCaracteristicas();
    }
}
