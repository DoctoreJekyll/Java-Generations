package Patrones.singleton;

public class SingletonInst {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstancia();
        Singleton s2 = Singleton.getInstancia();

        s1.mostrarMensaje();

        // Verificar que ambas variables apuntan al mismo objeto
        System.out.println(s1 == s2); // true
    }
}
