package generics;

public class Chocolatina {

    private String nombre;
    private double precio;

    public Chocolatina(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Chocolatina{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }

}
