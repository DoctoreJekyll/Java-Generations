package org.generations.springdemojbdcgenerations.mappers;

import org.generations.springdemojbdcgenerations.dto.EmpleadoOficinaDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoOficinaMapper implements RowMapper<EmpleadoOficinaDTO> {

    @Override
    public EmpleadoOficinaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpleadoOficinaDTO dto = new EmpleadoOficinaDTO();
        dto.setCodigo_empleado(rs.getString("codigo_empleado"));
        dto.setNombre(rs.getString("nombre"));
        dto.setApellido1(rs.getString("apellido1"));
        dto.setApellido2(rs.getString("apellido2"));
        dto.setEmail(rs.getString("email"));
        dto.setPuesto(rs.getString("puesto"));
        dto.setCiudad(rs.getString("ciudad"));
        return dto;
    }
}
