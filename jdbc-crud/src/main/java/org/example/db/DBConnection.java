package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String DB_URL = "jdbc:h2:~/test";
    private final String DB_USER = "sa";
    private final String DB_PASS = "";

    private static DBConnection instance;
    private Connection connection;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance.connection;
    }
}
