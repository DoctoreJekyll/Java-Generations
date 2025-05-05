package anotations;

public class Empleado extends Persona {

    public String codigoEmpleado;

    public Empleado(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public String concatenar() {
        return super.concatenar() + "-" + codigoEmpleado;
    }
}
