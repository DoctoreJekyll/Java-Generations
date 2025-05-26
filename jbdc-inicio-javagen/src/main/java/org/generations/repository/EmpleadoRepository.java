package org.generations.repository;


import org.generations.model.Empleado;
import org.generations.util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Esta clase representa un repo para gestionar todas las operaciones de la base de datos que se realicen con la
//tabla "empleado".
//Debe proporcionar todos los métodos necesarios para manejar la informacion requeridos por las especificaciones de la aplicacion.
public class EmpleadoRepository {

    private static final String SELECT_EMPLEADOS = "SELECT * FROM empleado";
    private static final String SELECT_EMPLEADO_BY_ID = "SELECT * FROM empleado WHERE codigo_empleado = ?";

    //Como aqui vamos a hacer consultas primero necesitamos una conexion
    private Connection getConnection() throws SQLException {
        return DBConnection.connection();
    }

    private Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    public Empleado empleadoById(int id){
        Empleado empleado = null;
        return empleado;
    }

    //Este metodo se esta conectando a la base de datos, esta creando un empleado,
    // rellenando todas sus campos y añadiendo el empleado creado a la lista.
    public List<Empleado> getEmpleados(){
        List<Empleado> empleados = new ArrayList<>();

        try(Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_EMPLEADOS))
        {
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigoEmpleado(resultSet.getInt("codigo_empleado"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setApellido1(resultSet.getString("apellido1"));
                empleado.setApellido2(resultSet.getString("apellido2"));
                empleado.setEmail(resultSet.getString("email"));
                empleado.setExtension(resultSet.getString("extension"));
                empleado.setCodigoOficina(resultSet.getString("codigo_oficina"));
                empleado.setCodigoJefe(resultSet.getInt("codigo_jefe"));
                empleado.setPuesto(resultSet.getString("puesto"));

                empleados.add(empleado);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }

}
