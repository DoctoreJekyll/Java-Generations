package com.vehicles;

public class Vehiculo {

    public int precioDia;
    public String modelo;
    public int numLlantas;

    public Vehiculo(int precioDia, String modelo, int numLlantas) {
        this.precioDia = precioDia;
        this.modelo = modelo;
        this.numLlantas = numLlantas;
    }

    public void mostrarCaracteristicas()
    {
        System.out.println("Modelo: " + modelo);
        System.out.println("Numero de Llantas: " + numLlantas);
        System.out.println("Precio Dia: " + precioDia);
    }

    public void encenderMotor()
    {
        System.out.println("Motor encendido");
    }

    public void apagarMotor()
    {
        System.out.println("Motor apagado");
    }

    public void funciona()
    {
        System.out.println("Funciona");
    }
}
