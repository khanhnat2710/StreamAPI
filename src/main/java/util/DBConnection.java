package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private final static String HOSTNAME = "localhost";
    private final static String DATABASE ="student_db";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "";
    private final static String URL = "jdbc:mysql://" + HOSTNAME + "/" + DATABASE;
    public static Connection connection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
