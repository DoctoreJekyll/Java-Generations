package org.generations.springdemojbdcgenerations.mappers;

import org.generations.springdemojbdcgenerations.dto.Empleado;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoMapper implements RowMapper<Empleado> {
    @Override
    public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setId(rs.getInt("codigo_empleado"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido1(rs.getString("apellido1"));
        empleado.setApellido2(rs.getString("apellido2"));
        empleado.setEmail(rs.getString("email"));
        empleado.setPuesto(rs.getString("puesto"));



        //Tener estas lineas me tirar error por lo que solo tenemos que mapear los valores que vamos a pedir en las querys?
        //He solucionado los errores comentando las lineas que no se piden en el ejercicio.
        //Osea tendriamos que tener un mapper distinto para cada caso de la query?
        //Y en ese caso, si no me sirve acceder al empleado tendriamos que crear objetos auxiliares con los datos que necesitamos
        //Acceder en cada caso de la query?

        //empleado.setExtension(rs.getString("extension"));
        //empleado.setCodigo_jefe(rs.getString("codigo_jefe"));


        return empleado;
    }
}
