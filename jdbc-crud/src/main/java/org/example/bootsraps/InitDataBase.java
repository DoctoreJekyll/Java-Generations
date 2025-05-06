package org.example.bootsraps;

import org.example.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDataBase {

    public static void init() {
        Connection connection = DBConnection.getConnection();
        String sql = getCustomerCreateQuery();
        try(Statement statement = connection.createStatement())
        {
            statement.execute(sql);
        }
        catch (SQLException exception)
        {
            exception.printStackTrace();
        }
    }

    private static String getCustomerCreateQuery() {
        return "CREATE TABLE IF NOT EXISTS CUSTOMERS (ID_CUSTOMER IDENTITY NOT NULL PRIMARY KEY, FIRST_NAME VARCHAR(255), LAST_NAME VARCHAR(255), EMAIL VARCHAR(255))";
    }
}
