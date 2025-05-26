package org.generations;

import org.generations.util.DBConnection;

import java.sql.*;

public class StepOne {


    public static void main(String[] args) throws SQLException {
        Connection connection = DBConnection.connection();

        query1(connection);
        query2(connection);

        DBConnection.CloseConnection();
    }

    public static void query1(Connection connection)
    {
        String query = "SELECT c.nombre_cliente, e.nombre, e.apellido1 " +
                "FROM cliente c " +
                "JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);)
        {


            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("nombre_cliente");
                String nombreRep = resultSet.getString("nombre");

                System.out.println("Cliente: " + nombreCliente);
                System.out.println("Representante: " + nombreRep);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    //Devuelve un listado con el nombre de los empleados junto con el nombre de sus jefes.
    public static void query2(Connection connection1)
    {
        String query2 = """
                SELECT e.nombre AS empleado, j.nombre AS jefe
                FROM empleado e
                JOIN empleado j ON e.codigo_jefe = j.codigo_empleado
                ORDER BY e.nombre ASC;
                """;

        try (
                Statement statement = connection1.createStatement();
                ResultSet resultSet = statement.executeQuery(query2);
        )
        {
            while (resultSet.next()) {
                String nombreEmpleado = resultSet.getString("empleado");
                String nombreJefe = resultSet.getString("jefe");

                System.out.println("Empleado: " + nombreEmpleado);
                System.out.println("Jefe: " + nombreJefe);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //9. Devuelve un listado que muestre el nombre de cada empleado, el nombre de su jefe y el nombre del jefe.
    public static void query3(Connection connection)
    {
        String query = """
            SELECT e.nombre AS empleado, j.nombre AS jefe, jj.nombre AS jefe_del_jefe
            FROM empleado e
            INNER JOIN empleado j ON e.codigo_jefe = j.codigo_empleado
            INNER JOIN empleado jj ON j.codigo_jefe = jj.codigo_empleado;
            """;

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                String nombreEmpleado = resultSet.getString("empleado");
                String nombreJefe = resultSet.getString("jefe");
                String nombreJefeDelJefe = resultSet.getString("jefe_del_jefe");

                System.out.println("Empleado: " + nombreEmpleado);
                System.out.println("Jefe: " + nombreJefe);
                System.out.println("Jefe del jefe: " + nombreJefeDelJefe);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }


    //Devuelve el nombre de los clientes a los que no se les ha entregado a tiempo un pedido.
    public static void query4(Connection connection)
    {
        String query = """
            SELECT DISTINCT c.nombre_cliente
            FROM cliente c
            INNER JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
            WHERE p.fecha_entrega > p.fecha_esperada
            """;

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("nombre_cliente");
                System.out.println("Cliente con retraso en entrega: " + nombreCliente);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }


    //Devuelve un listado de las diferentes gamas de producto que ha comprado cada cliente.
    public static void query5(Connection connection)
    {
        String query = """
            SELECT DISTINCT c.nombre_cliente, prod.gama
            FROM cliente c
            JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
            JOIN detalle_pedido dp ON dp.codigo_pedido = p.codigo_pedido
            JOIN producto prod ON prod.codigo_producto = dp.codigo_producto
            ORDER BY c.nombre_cliente
            """;

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("nombre_cliente");
                String gama = resultSet.getString("gama");

                System.out.println("Cliente: " + nombreCliente + " | Gama: " + gama);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }


}
