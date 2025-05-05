package Patrones.singleton;

public class Singleton {
    // 1. Instancia privada y estática de la misma clase
    private static Singleton instancia;

    // 2. Constructor privado para evitar que se cree desde fuera
    private Singleton() {
        System.out.println("Instancia creada");
    }

    // 3. Metodo público y estático para obtener la instancia
    public static Singleton getInstancia() {
        if (instancia == null) {
            instancia = new Singleton();
        }
        return instancia;
    }

    // Metodo de ejemplo
    public void mostrarMensaje() {
        System.out.println("Hola desde el Singleton");
    }
}
