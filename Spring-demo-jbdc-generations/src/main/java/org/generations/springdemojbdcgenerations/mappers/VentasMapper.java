package org.generations.springdemojbdcgenerations.mappers;

import org.generations.springdemojbdcgenerations.dto.VentasDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VentasMapper implements RowMapper<VentasDTO> {
    @Override
    public VentasDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        VentasDTO ventasDTO = new VentasDTO();
        ventasDTO.setCodigo_empleado(rs.getString("codigo_empleado"));
        ventasDTO.setNombre(rs.getString("nombre"));
        ventasDTO.setApellido1(rs.getString("apellido1"));
        ventasDTO.setApellido2(rs.getString("apellido2"));
        ventasDTO.setPuesto(rs.getString("puesto"));
        ventasDTO.setCiudad(rs.getString("ciudad"));
        ventasDTO.setGama(rs.getString("gama"));
        ventasDTO.setTotalVentas(rs.getDouble("total_ventas"));
        return ventasDTO;
    }
}
