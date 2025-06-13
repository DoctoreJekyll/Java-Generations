package org.cplcursos.springdata.repositorios;

import org.cplcursos.springdata.DTOs.OficinaDTOLista;

import java.util.List;

/**
 * Esta interfaz publica los métodos que se usarán
 */
public interface OficinaRepo {
    List<OficinaDTOLista> listaOficinas();
    String ciudadOficina(String codigoOficina);

}
