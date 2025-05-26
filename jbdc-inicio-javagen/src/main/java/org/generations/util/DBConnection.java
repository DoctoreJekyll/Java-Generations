package org.generations.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Patron de diseño singleton, creamos aquí la conexión
public class DBConnection {

    private static final String url = "jdbc:postgresql://localhost:5432/jardineria";
    private static final String user = "postgres";
    private static final String password = "4444";

    static Connection connection = null;

    public static Connection connection() throws SQLException {

        if (connection == null)
        {
            connection = DriverManager.getConnection(url, user,password);
        }

        return connection;
    }

    public static void CloseConnection() throws SQLException
    {
        connection.close();
    }

}
