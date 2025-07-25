package org.cpl_cursos.ejercicioClase_VII_spring_jdbc.controladores;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class JardineriaCtrl {

    private final OficinaCtrl oficinaCtrl;
    private final EmpleadoCtrl empleadoCtrl;

    private final Scanner scanner = new Scanner(System.in);

    public JardineriaCtrl(OficinaCtrl oficinaCtrl, EmpleadoCtrl empleadoCtrl) {
        this.oficinaCtrl = oficinaCtrl;
        this.empleadoCtrl = empleadoCtrl;
    }

    public void iniciarAplicacion() {
        System.out.println("=== APLICACIÓN JARDINERÍA ===");
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1 -> oficinaCtrl.mostrarListadoOficinas();
                case 2 -> empleadoCtrl.mostrarEmpleadosPorOficina();
                case 3 -> empleadoCtrl.mostrarVentasPorEmpleado();
                case 0 -> {
                    System.out.println("¡Hasta luego!");
                    continuar = false;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Listado de oficinas");
        System.out.println("2. Empleados por oficina");
        System.out.println("3. Ventas por empleado");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
