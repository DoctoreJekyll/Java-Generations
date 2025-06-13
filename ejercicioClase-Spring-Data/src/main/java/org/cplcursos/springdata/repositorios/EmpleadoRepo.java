package org.cplcursos.springdata.repositorios;

import org.cplcursos.springdata.DTOs.EmpleadoDTOLista;
import org.cplcursos.springdata.DTOs.OficinaDTOLista;
import org.cplcursos.springdata.DTOs.VentasEmpleadoDTO;
import org.cplcursos.springdata.modelos.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepo extends CrudRepository<Empleado,Integer> {
    List<Empleado> findAll();
}
