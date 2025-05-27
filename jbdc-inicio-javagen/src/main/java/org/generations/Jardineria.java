package org.generations;

import org.generations.model.Empleado;
import org.generations.model.Oficina;
import org.generations.repository.EmpleadoRepository;
import org.generations.repository.OficinaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Jardineria {

    static Scanner scanner = new Scanner(System.in);
    static EmpleadoRepository empleadoRepo = new EmpleadoRepository();
    static OficinaRepository oficinaRepo = new OficinaRepository();


    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        while (true) {
            System.out.println("¿Sobre qué entidad quieres operar?");
            System.out.println("1. Oficina");
            System.out.println("2. Empleado");
            System.out.println("0. Salir");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    menuOficinas();
                    break;
                case "2":
                    menuEmpleados();
                    break;
                case "0":
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private static void menuEmpleados() {
        while (true) {
            System.out.println("\n--- CRUD de Empleados ---");
            System.out.println("1. Listar empleados");
            System.out.println("2. Buscar empleado por ID");
            System.out.println("3. Crear nuevo empleado");
            System.out.println("4. Actualizar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("0. Volver al menú principal");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    List<Empleado> empleados = empleadoRepo.getEmpleados();
                    empleados.forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("ID del empleado: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Optional<Empleado> empleado = empleadoRepo.readEmpleado(id);
                    System.out.println(empleado);
                    break;
                case "3":
                    Empleado nuevo = new Empleado();
                    System.out.print("ID del empleado: ");
                    nuevo.setCodigoEmpleado(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Nombre: ");
                    nuevo.setNombre(scanner.nextLine());
                    System.out.print("Apellido1: ");
                    nuevo.setApellido1(scanner.nextLine());
                    System.out.print("Apellido2: ");
                    nuevo.setApellido2(scanner.nextLine());
                    System.out.print("Email: ");
                    nuevo.setEmail(scanner.nextLine());
                    System.out.print("Extensión: ");
                    nuevo.setExtension(scanner.nextLine());
                    System.out.print("Código oficina: ");
                    validateOficina(nuevo);
                    System.out.print("Código jefe: ");
                    nuevo.setCodigoJefe(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Puesto: ");
                    nuevo.setPuesto(scanner.nextLine());

                    empleadoRepo.createEmpleado(nuevo);
                    System.out.println("Empleado creado.");
                    break;
                case "4":
                    System.out.print("ID del empleado a actualizar: ");
                    int idAct = Integer.parseInt(scanner.nextLine());
                    Optional<Empleado> empActOpt = empleadoRepo.readEmpleado(idAct);

                    if (empActOpt.isEmpty()) {
                        System.out.println("Empleado no encontrado.");
                        break;
                    }

                    Empleado empAct = empActOpt.get();

                    System.out.print("Nuevo nombre: ");
                    empAct.setNombre(scanner.nextLine());
                    System.out.print("Nuevo apellido1: ");
                    empAct.setApellido1(scanner.nextLine());
                    System.out.print("Nuevo apellido2: ");
                    empAct.setApellido2(scanner.nextLine());
                    System.out.print("Nuevo email: ");
                    empAct.setEmail(scanner.nextLine());
                    System.out.print("Nueva extensión: ");
                    empAct.setExtension(scanner.nextLine());
                    System.out.print("Nuevo código oficina: ");
                    validateOficina(empAct);
                    System.out.print("Nuevo código jefe: ");
                    empAct.setCodigoJefe(Integer.parseInt(scanner.nextLine()));
                    System.out.print("Nuevo puesto: ");
                    empAct.setPuesto(scanner.nextLine());

                    empleadoRepo.updateEmpleado(empAct);
                    System.out.println("Empleado actualizado.");
                    break;
                case "5":
                    System.out.print("ID del empleado a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());

                    Optional<Empleado> empleadoEliminar = empleadoRepo.readEmpleado(idEliminar);
                    if (empleadoEliminar.isEmpty()) {
                        System.out.println("❌ Empleado no encontrado. No se puede eliminar.");
                        break;
                    }

                    empleadoRepo.deleteEmpleado(idEliminar);
                    System.out.println("✅ Empleado eliminado correctamente.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void validateOficina(Empleado nuevo) {
        String codigoOficina;
        while (true) {
            System.out.print("Código de oficina: ");
            codigoOficina = scanner.nextLine();

            Optional<Oficina> oficina = oficinaRepo.readOficina(codigoOficina);
            if (oficina.isPresent()) {
                break; // Oficina válida, salimos del bucle
            } else {
                System.out.println("La oficina no existe. Por favor, introduce un código válido.");
                System.out.println("Oficinas disponibles:");
                List<Oficina> oficinas = oficinaRepo.getOficinas();
                for (Oficina o : oficinas) {
                    System.out.println("- " + o.getCodigoOficina() + " | " + o.getCiudad());
                }
            }
        }
        nuevo.setCodigoOficina(codigoOficina);
    }

    private static void menuOficinas() {
        while (true) {
            System.out.println("\n--- CRUD de Oficinas ---");
            System.out.println("1. Listar oficinas");
            System.out.println("2. Buscar oficina por código");
            System.out.println("3. Crear nueva oficina");
            System.out.println("4. Actualizar oficina");
            System.out.println("5. Eliminar oficina");
            System.out.println("0. Volver al menú principal");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    List<Oficina> oficinas = oficinaRepo.getOficinas();
                    oficinas.forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("Código de oficina: ");
                    String codigo = scanner.nextLine();
                    Optional<Oficina> oficina = oficinaRepo.readOficina(codigo);
                    System.out.println(oficina);
                    break;
                case "3":
                    Oficina nueva = new Oficina();
                    System.out.print("Código oficina: ");
                    nueva.setCodigoOficina(scanner.nextLine());
                    System.out.print("Ciudad: ");
                    nueva.setCiudad(scanner.nextLine());
                    System.out.print("País: ");
                    nueva.setPais(scanner.nextLine());
                    System.out.print("Región: ");
                    nueva.setRegion(scanner.nextLine());
                    System.out.print("Código Postal: ");
                    nueva.setCodigoPostal(scanner.nextLine());
                    System.out.print("Teléfono: ");
                    nueva.setTelefono(scanner.nextLine());
                    System.out.print("Dirección 1: ");
                    nueva.setLineaDireccion1(scanner.nextLine());
                    System.out.print("Dirección 2: ");
                    nueva.setLineaDireccion2(scanner.nextLine());

                    oficinaRepo.createOficina(nueva);
                    System.out.println("Oficina creada.");
                    break;
                case "4":
                    System.out.print("Código de la oficina a actualizar: ");
                    String codAct = scanner.nextLine();
                    Optional<Oficina> oficinaActualizarOpt = oficinaRepo.readOficina(codAct);
                    if (oficinaActualizarOpt.isEmpty()) {
                        System.out.println("Oficina no encontrada. No se puede realizar la actualización.");
                        break;
                    }
                    Oficina oficinaActualizar = oficinaActualizarOpt.get();
                    System.out.print("Nueva ciudad: ");
                    oficinaActualizar.setCiudad(scanner.nextLine());
                    System.out.print("Nuevo país: ");
                    oficinaActualizar.setPais(scanner.nextLine());
                    System.out.print("Nueva región: ");
                    oficinaActualizar.setRegion(scanner.nextLine());
                    System.out.print("Nuevo código postal: ");
                    oficinaActualizar.setCodigoPostal(scanner.nextLine());
                    System.out.print("Nuevo teléfono: ");
                    oficinaActualizar.setTelefono(scanner.nextLine());
                    System.out.print("Nueva dirección 1: ");
                    oficinaActualizar.setLineaDireccion1(scanner.nextLine());
                    System.out.print("Nueva dirección 2: ");
                    oficinaActualizar.setLineaDireccion2(scanner.nextLine());
                    try {
                        oficinaRepo.updateOficina(oficinaActualizar);
                        System.out.println("Oficina actualizada correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al actualizar la oficina: " + e.getMessage());
                    }
                    break;
                case "5":
                    System.out.print("Código de la oficina a eliminar: ");
                    String codEliminar = scanner.nextLine();
                    // Comprobamos si existe antes de eliminar
                    Optional<Oficina> oficinaEliminar = oficinaRepo.readOficina(codEliminar);
                    if (oficinaEliminar.isEmpty()) {
                        System.out.println("Oficina no encontrada. No se puede eliminar.");
                        break;
                    }
                    // Si existe, la eliminamos
                    oficinaRepo.deleteOficina(codEliminar);
                    System.out.println("Oficina eliminada correctamente.");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }


}
