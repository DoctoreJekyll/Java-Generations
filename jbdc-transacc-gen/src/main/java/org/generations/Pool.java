package org.generations;

import com.zaxxer.hikari.HikariDataSource;
import org.generations.util.DBConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Pool {
    private static final int CONNECTION_POOL_SIZE = 10;
    private static final String url = "jdbc:postgresql://localhost:5432/jardineria";
    private static final String user = "postgres";
    private static final String pass = "4444";

    public static void main(String[] args) throws SQLException {
        long initTime = System.currentTimeMillis();

        for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
            Connection connection = DBConnection.getConnection();
            connection.close();
        }
        long endTime = System.currentTimeMillis();

        System.out.println("<UNK>" + (endTime - initTime) + "ms");

        System.out.println("----------------------hikaria---------------------------");

        DataSource dataSource = DBConnection.getPoolConnection(CONNECTION_POOL_SIZE);

        long initTime2 = System.currentTimeMillis();

        for (int i = 0; i < CONNECTION_POOL_SIZE; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long endTime2 = System.currentTimeMillis();

        System.out.println("<UNK>" + (endTime2 - initTime2) + "ms");
    }
}
