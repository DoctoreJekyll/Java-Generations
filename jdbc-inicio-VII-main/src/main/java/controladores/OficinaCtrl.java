package controladores;

import modelos.Oficina;
import repositorios.OficinaRepo;
import servicios.OficinaSrvc;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

public class OficinaCtrl {

    OficinaSrvc oficinaSrvc = new OficinaSrvc();
    Scanner scanner = new Scanner(System.in);

    public void listarOficinas() throws SQLException {
        oficinaSrvc.listaOficinas().forEach(System.out::println);
    }

    public void leerOficinaxId() throws SQLException {
        System.out.println("Indique el id de la oficina: ");
        // preguntamos el id de la oficina y vamos a buscar sus datos
        OficinaRepo repoOfi = null;
        Optional<Oficina> ofi = repoOfi.leerOficinaxId(scanner.nextLine());
        ofi.ifPresent(System.out::println);
        if (ofi.isEmpty()) {
            System.out.println("El id de la oficina no existe");
        }

    }

    public void crearOficina() throws SQLException {
        Oficina ofi = new Oficina();
        System.out.println("Introduzca los datos de la oficina: ");
        System.out.println("Código de oficina: ");
        ofi.setCodigoOficina(scanner.nextLine());
        System.out.println("Ciudad:");
        ofi.setCiudad(scanner.nextLine());
        OficinaRepo repoOfi = new OficinaRepo();
        repoOfi.CrearOficina(ofi);
        // Comprobamos sio se ha creado la oficina
        Optional<Oficina> ofiGrabada = repoOfi.leerOficinaxId(ofi.getCodigoOficina());
        if (ofiGrabada.isPresent()) {
            System.out.println("la oficina se ha grabado correctamente.");
        } else {
            System.out.println("la oficina no se ha grabado correctamente.");
        }
    }

    public void modifiarOficina() {
        System.out.println("Modificar oficina:");
        System.out.print("Introduce el código de la oficina que quieres modificar: ");
        String codigoModificar = scanner.nextLine();
        Oficina oficina = new Oficina();
        try {
            OficinaRepo repoOfi = new OficinaRepo();
            Optional<Oficina> oficinaExistenteOpt = repoOfi.leerOficinaxId(codigoModificar);

            leerYModificarCampos(scanner, oficinaExistenteOpt.get(), repoOfi);

            // Utilizamos las posibilidades de la clase Optional para programación funcional
                        oficinaExistenteOpt.ifPresentOrElse(
                                ofi -> {
                                    try {
                                        System.out.println(repoOfi.actualizarOficina(preguntarCampos(ofi))  //utilizamos un if ternario
                                                ? "Oficina actualizada correctamente."
                                                : "No se pudo actualizar la oficina :"
                                        );
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                },
                                () -> System.out.println("No se encontró ninguna oficina con ese código.")
                        );
        } catch (SQLException e) {
            System.out.println("Error al modificar la oficina: " + e.getMessage());
        }
    }

    private void leerYModificarCampos(Scanner scanner, Oficina oficina, OficinaRepo repoOfi) {
    }

    private Oficina preguntarCampos(Oficina ofi) {
        return ofi;
    }
}
