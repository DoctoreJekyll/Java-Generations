package org.generations;

import java.sql.*;

public class StepOne {
    public static void main(String[] args) {
        //Definicion de parametros de conexion a la base de datos
        String url = "jdbc:postgresql://localhost:5432/jardineria";
        String user = "postgres";
        String password = "4444";

        //Creamos la instrancia de la conexion a la bbdd
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            // Creamos una instancia de sentencia para poder enviar consultas al servidor de bbdd
            Statement st = connection.createStatement();
            //definimos la consulta, la enviamos al servidor y obtenemos el resultado
            ResultSet rs = st.executeQuery("SELECT * FROM cliente");
            //en el resulset tenemos todos los registros devueltos por el servidor dentro de un iterador
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

            rs.close();
            st.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
