package org.cplcursos.springdata.mapeadores;

import org.cplcursos.springdata.DTOs.VentasEmpleadoDTO;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class VentasMapper {

    public VentasEmpleadoDTO toDTO(ResultSet rs, int rowNum) throws SQLException {
        VentasEmpleadoDTO ventasDTO = new VentasEmpleadoDTO();
        ventasDTO.setCodigoEmpleado(rs.getInt("codigo_empleado"));
        ventasDTO.setNombreCompleto(rs.getString("nombre_completo"));
        ventasDTO.setCiudadOficina(rs.getString("ciudad_oficina"));
        ventasDTO.setPuesto(rs.getString("puesto"));
        ventasDTO.setVentasGama(rs.getBigDecimal("ventas_gama"));
        ventasDTO.setGama(rs.getString("gama"));
        return ventasDTO;
    }
}
