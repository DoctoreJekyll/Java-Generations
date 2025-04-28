package enums.example3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado(EmpleadoTipo.ADMINISTRADOR, "Guillermo", "Mendoza", "<EMAIL>");
        System.out.println(empleado);

        Empleado empleado1 = new Empleado(EmpleadoTipo.TECNICO, "Javier", "Perez", "<EMAIL>");
        System.out.println(empleado1);

        List<Empleado> empleados = List.of(empleado, empleado1);
        ListOfEmpleados(empleados);
    }

    public static void ListOfEmpleados(List<Empleado> empleados)
    {
        for (Empleado e : empleados){
            System.out.println(e.getNombre() + e.getTipo());
        }
    }
}
