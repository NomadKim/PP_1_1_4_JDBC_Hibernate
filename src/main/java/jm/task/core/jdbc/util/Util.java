package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static Connection getConnection() throws SQLException {

        String hostName = "localhost";
        String dbName = "USERDAO";
        String userName = "root";
        String password = "javadb01";

        return getConnection(hostName, dbName, userName, password);
    }

    public static Connection getConnection(String hostName, String dbName,
                                           String userName, String password) throws SQLException {

        String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        return DriverManager.getConnection(url, userName, password);
    }
}
