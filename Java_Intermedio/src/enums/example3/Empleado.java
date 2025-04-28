package enums.example3;

public class Empleado {
    private EmpleadoTipo tipo;
    private String nombre;
    private String apellido;
    private String email;
    private double salario;

    public Empleado(EmpleadoTipo tipo, String nombre, String apellido, String email) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        salario = tipo.getSalario();
    }

    public EmpleadoTipo getTipo() {
        return tipo;
    }

    public void setTipo(EmpleadoTipo tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empleado{" + "tipo=" + tipo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", salario=" + salario + '}';
    }
}
