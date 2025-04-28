package generics;

public class Golosina {

    private String nombre;
    private double precio;

    public Golosina(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Golosina{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }
}
