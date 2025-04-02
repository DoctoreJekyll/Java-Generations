package com.solid.op.green;

public abstract class Car {

    private String marca;

    public Car(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    abstract int getPrice();
}
