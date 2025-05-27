package org.generations.repository;


import org.generations.model.Empleado;
import org.generations.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Esta clase representa un repo para gestionar todas las operaciones de la base de datos que se realicen con la
//tabla "empleado".
//Debe proporcionar todos los métodos necesarios para manejar la informacion requeridos por las especificaciones de la aplicacion.
public class EmpleadoRepository {

    private static final String SELECT_EMPLEADOS = "SELECT * FROM empleado";

    //Como aqui vamos a hacer consultas primero necesitamos una conexion
    private Connection getConnection() throws SQLException {
        return DBConnection.connection();
    }

    private Statement getStatement() throws SQLException {
        return getConnection().createStatement();
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
                loadEmpleado(empleado, resultSet);

                empleados.add(empleado);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return empleados;
    }

    //Pâra leer un empleado concreto
    public Optional<Empleado> readEmpleado(Integer id){
        Empleado empleado = null;

        String query = "SELECT * FROM empleado WHERE codigo_empleado = ?";

        try(PreparedStatement statement = getConnection().prepareStatement(query);) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empleado = new Empleado();
                loadEmpleado(empleado, resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.ofNullable(empleado);
    }

    public void createEmpleado(Empleado empleado) {
        String query = "INSERT INTO empleado (codigo_empleado, nombre, apellido1, apellido2, email, extension, codigo_oficina, codigo_jefe, puesto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, empleado.getCodigoEmpleado());
            statement.setString(2, empleado.getNombre());
            statement.setString(3, empleado.getApellido1());
            statement.setString(4, empleado.getApellido2());
            statement.setString(5, empleado.getEmail());
            statement.setString(6, empleado.getExtension());
            statement.setString(7, empleado.getCodigoOficina());
            statement.setInt(8, empleado.getCodigoJefe());
            statement.setString(9, empleado.getPuesto());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmpleado(Empleado empleado) {
        String query = "UPDATE empleado SET nombre = ?, apellido1 = ?, apellido2 = ?, email = ?, extension = ?, codigo_oficina = ?, codigo_jefe = ?, puesto = ? WHERE codigo_empleado = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellido1());
            statement.setString(3, empleado.getApellido2());
            statement.setString(4, empleado.getEmail());
            statement.setString(5, empleado.getExtension());
            statement.setString(6, empleado.getCodigoOficina());
            statement.setInt(7, empleado.getCodigoJefe());
            statement.setString(8, empleado.getPuesto());
            statement.setInt(9, empleado.getCodigoEmpleado());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmpleado(Integer id) {
        String query = "DELETE FROM empleado WHERE codigo_empleado = ?";

        try (PreparedStatement statement = getConnection().prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private void loadEmpleado(Empleado empleado, ResultSet resultSet) throws SQLException {
        empleado.setCodigoEmpleado(resultSet.getInt("codigo_empleado"));
        empleado.setNombre(resultSet.getString("nombre"));
        empleado.setApellido1(resultSet.getString("apellido1"));
        empleado.setApellido2(resultSet.getString("apellido2"));
        empleado.setEmail(resultSet.getString("email"));
        empleado.setExtension(resultSet.getString("extension"));
        empleado.setCodigoOficina(resultSet.getString("codigo_oficina"));
        empleado.setCodigoJefe(resultSet.getInt("codigo_jefe"));
        empleado.setPuesto(resultSet.getString("puesto"));
    }



}
