package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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

    public static SessionFactory getHibernateConnection() throws SQLException {

        String hostName = "localhost";
        String dbName = "USERDAO";
        String userName = "root";
        String password = "javadb01";

        return getHibernateConnection(hostName, dbName, userName, password);
    }

    public static SessionFactory getHibernateConnection(String hostName, String dbName,
                                                        String userName, String password) throws SQLException {

        String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        props.put("hibernate.connection.url", url);
        props.put("hibernate.connection.username", userName);
        props.put("hibernate.connection.password", password);
        return new Configuration().addProperties(props).addAnnotatedClass(User.class).buildSessionFactory();
    }


}
