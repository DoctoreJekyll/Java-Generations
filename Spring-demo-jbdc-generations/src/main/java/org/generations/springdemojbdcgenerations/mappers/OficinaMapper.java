package org.generations.springdemojbdcgenerations.mappers;

import org.generations.springdemojbdcgenerations.models.Oficina;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OficinaMapper implements RowMapper<Oficina> {
    @Override
    public Oficina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Oficina oficina = new Oficina();
        oficina.setCodigo_oficina(rs.getString("codigo_oficina"));
        oficina.setCiudad(rs.getString("ciudad"));
        oficina.setTelefono(rs.getString("telefono"));
        oficina.setLinea_direccion1(rs.getString("linea_direccion1"));
        oficina.setLinea_direccion2(rs.getString("linea_direccion2"));

        return oficina;
    }
}
