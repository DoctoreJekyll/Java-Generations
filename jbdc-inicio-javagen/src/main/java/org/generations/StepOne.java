package org.generations;

import java.sql.*;

public class StepOne {
    //Definicion de parametros de conexion a la base de datos
    static String url = "jdbc:postgresql://localhost:5432/jardineria";
    static String user = "postgres";
    static String password = "4444";


    public static void main(String[] args) {
        query4();
    }

    public static void query1()
    {
        String query = "SELECT c.nombre_cliente, e.nombre, e.apellido1 " +
                "FROM cliente c " +
                "JOIN empleado e ON c.codigo_empleado_rep_ventas = e.codigo_empleado";

        try (
                Connection connection1 = DriverManager.getConnection(url, user, password);
                Statement statement = connection1.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
            )
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

    public static void query2()
    {
        String query2 = """
                SELECT e.nombre AS empleado, j.nombre AS jefe
                FROM empleado e
                JOIN empleado j ON e.codigo_jefe = j.codigo_empleado
                ORDER BY e.nombre ASC;
                """;

        try (
                Connection connection1 = DriverManager.getConnection(url, user, password);
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

    public static void query3()
    {
        String query = """
                SELECT e.nombre AS empleado, j.nombre AS jefe, jj.nombre AS jefe_del_jefe
                FROM empleado e
                INNER JOIN empleado j ON e.codigo_jefe = j.codigo_empleado
                INNER JOIN empleado jj ON j.codigo_jefe = jj.codigo_empleado;
                """;

        try (
                Connection connection1 = DriverManager.getConnection(url, user, password);
                Statement statement = connection1.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                String nombreEmpleado = resultSet.getString("empleado");
                String nombreJefe = resultSet.getString("jefe");
                String nombreJefeDelJefe = resultSet.getString("jefe_del_jefe");

                System.out.println("el empleado es:" + nombreEmpleado);
                System.out.println("el jefe es:" + nombreJefe);
                System.out.println("el jefe del jefe es:" + nombreJefeDelJefe);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void query4()
    {
        String query = """
                SELECT DISTINCT c.nombre_cliente
                FROM cliente c
                INNER JOIN pedido p ON c.codigo_cliente = p.codigo_cliente
                WHERE p.fecha_entrega > p.fecha_esperada
                """;

        try (
                Connection connection1 = DriverManager.getConnection(url, user, password);
                Statement statement = connection1.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        )
        {
            while (resultSet.next()) {
                String nombreCliente = resultSet.getString("nombre_cliente");
                System.out.println("Clientes que no se han entregado a tiempo " +  nombreCliente);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

}
