package org.cplcursos.springdata.servicios;


import org.cplcursos.springdata.DTOs.EmpleadoDTOLista;
import org.cplcursos.springdata.DTOs.OficinaDTOLista;
import org.cplcursos.springdata.DTOs.VentasEmpleadoDTO;
import org.cplcursos.springdata.modelos.Empleado;
import org.cplcursos.springdata.repositorios.EmpleadoRepo;
import org.cplcursos.springdata.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JardineriaSrvc {

    private final OficinaRepo oficinaRepo;
    private final EmpleadoRepo empleadoRepo;

    public JardineriaSrvc(OficinaRepo oficinaRepo, EmpleadoRepo empleadoRepo) {
        this.oficinaRepo = oficinaRepo;
        this.empleadoRepo = empleadoRepo;
    }

    public List<Empleado> listarEmpleados() {
        return empleadoRepo.findAll();
    }

    public List<OficinaDTOLista> listarOficinas() {
        return oficinaRepo.listaOficinas();
    }

}
