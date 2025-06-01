package org.generations;

import org.generations.util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

//        String query = "select * from producto";
//
//        try(Statement statement = DBConnection.getConnection().createStatement();
//        ResultSet result = statement.executeQuery(query))
//        {
//            while(result.next()) {
//                System.out.println(result.getString("codigo_producto"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Insertamos un registro");
        String qry = "insert into cliente (codigo_cliente,nombre_cliente,telefono,linea_direccion1,fax,ciudad) values (?,?,?,?,?,?)";

        try(PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(qry);) {

            DBConnection.getConnection().setAutoCommit(false);

            preparedStatement.setInt(1, 105);
            preparedStatement.setString(2, "Sara");
            preparedStatement.setString(3, "test");
            preparedStatement.setString(4, "test");
            preparedStatement.setString(5, "test");
            preparedStatement.setString(6, "test");
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado " + preparedStatement.getUpdateCount());


            preparedStatement.setInt(1, 106);
            preparedStatement.setString(2, "Carlos");
            preparedStatement.setString(3, "test");
            preparedStatement.setString(4, "test");
            preparedStatement.setString(5, "test");
            preparedStatement.setString(6, "test");
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado " + preparedStatement.getUpdateCount());

            preparedStatement.setInt(1, 107);
            preparedStatement.setString(2, "Carlos");
            preparedStatement.setString(3, "test");
            preparedStatement.setString(4, "test");
            preparedStatement.setString(5, "test");
            preparedStatement.setString(6, "test");
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado " + preparedStatement.getUpdateCount());

            preparedStatement.setInt(1, 108);
            preparedStatement.setString(2, "Carlos");
            preparedStatement.setString(3, "test");
            preparedStatement.setString(4, "test");
            preparedStatement.setString(5, "test");
            preparedStatement.setString(6, "test");
            preparedStatement.executeUpdate();
            System.out.println("Registro insertado " + preparedStatement.getUpdateCount());

            DBConnection.getConnection().commit();

        }

        String qry2 = "select * from cliente where codigo_cliente = 105";
        try(Statement statement = DBConnection.getConnection().createStatement();) {
            ResultSet resultSet = statement.executeQuery(qry2);
            while(resultSet.next()) {
                System.out.println(resultSet.getString(2));
            }

        }
    }
}