package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.servicios.JardineriaSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/empleados")
public class EmpleadoCtrl {

    private final JardineriaSrvc jardineriaSrvc;

    public EmpleadoCtrl(JardineriaSrvc jardineriaSrvc) {
        this.jardineriaSrvc = jardineriaSrvc;
    }

    @GetMapping({"", "/"})
    public String mostrarEmpleadosPorOficina(Model modelo) {
        List<EmpleadoDTOLista> listaEmpleados = jardineriaSrvc.listarEmpleados();
        List<String> cabeceras = List.of("Código", "Nombre", "Apellidos", "Correo", "Ciudad", "Puesto");

        List<Map<String, Object>> filas = new ArrayList<>();
        for (EmpleadoDTOLista empleadoDTOLista : listaEmpleados) {
            Map<String, Object> fila = new HashMap<>();
            fila.put("codigo", empleadoDTOLista.getCodigoEmpleado());
            fila.put("nombre", empleadoDTOLista.getNombre());
            fila.put("Apellidos", empleadoDTOLista.getApellido1() + empleadoDTOLista.getApellido2());
            fila.put("Correo", empleadoDTOLista.getEmail());
            fila.put("Ciudad", empleadoDTOLista.getNombre());
            fila.put("Puesto", empleadoDTOLista.getPuesto());



            filas.add(fila);
        }

        List<Object> val = new ArrayList<>();
        for (Map<String, Object> fila : filas) {
            Object nombre = fila.get("Ciudad"); // o el nombre real de la clave
            val.add(nombre);
        }


        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);

        return "vistaLista";
    }

    public void mostrarVentasPorEmpleado() {

    }

    private void imprimirEmpleado(EmpleadoDTOLista empleado) {
        System.out.printf("  - %s %s %s (%s) - %s%n",
                empleado.getNombre(),
                empleado.getApellido1(),
                empleado.getApellido2() != null ? empleado.getApellido2() : "",
                empleado.getPuesto(),
                empleado.getEmail());
    }

}
