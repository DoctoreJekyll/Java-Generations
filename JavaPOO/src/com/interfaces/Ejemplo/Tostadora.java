package com.interfaces.Ejemplo;

public class Tostadora implements Preciable{

    private String marca;
    private double precio;

    public Tostadora(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Tostadora{" +
                "marca='" + marca + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double getPrecio() {
        return precio;
    }
}
