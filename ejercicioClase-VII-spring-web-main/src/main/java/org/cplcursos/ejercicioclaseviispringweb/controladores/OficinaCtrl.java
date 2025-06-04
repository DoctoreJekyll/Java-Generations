package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.servicios.JardineriaSrvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/oficinas")
public class OficinaCtrl {

    private final JardineriaSrvc jardineriaSrvc;

    public OficinaCtrl(JardineriaSrvc jardineriaSrvc) {
        this.jardineriaSrvc = jardineriaSrvc;
    }

    @GetMapping({"", "/"})
    public String mostrarListaOficinas(Model modelo) {
        List<OficinaDTOLista> listaOfcinas = jardineriaSrvc.listarOficinas();
        List<String> cabeceras = List.of("Código", "Ciudad", "Dirección 1", "Dirección 2", "Teléfono");

        List<Map<String, Object>> filas = new ArrayList<>();
        for (OficinaDTOLista oficina : listaOfcinas) {
            Map<String, Object> fila = new HashMap<>();
            fila.put("codigo", oficina.getCodigoOficina());
            fila.put("Ciudad", oficina.getCiudad());

            filas.add(fila);
        }

        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);
        return "vistaLista";
    }

    @GetMapping("/5")
    public String fichaOficina(Model modelo) {

        return null;
    }

}
