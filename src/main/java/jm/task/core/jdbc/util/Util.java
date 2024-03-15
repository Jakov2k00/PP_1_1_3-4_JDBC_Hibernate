package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "Jakov2k00";
    private static final String PASSWORD = "root";

    private Util() {

    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (!connection.isClosed() || connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
