package org.generations;

import org.postgresql.ds.PGSimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceExample {

    public static void main(String[] args) throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setPortNumber(5432);
        dataSource.setUser("postgres");
        dataSource.setPassword("4444");
        dataSource.setDatabaseName("jardineria");
        Connection connection = dataSource.getConnection();

        connection.setAutoCommit(false);
    }


}
