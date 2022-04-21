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
    private final static String hostName = "localhost";
    private final static String dbName = "USERDAO";
    private final static String userName = "root";
    private final static String password = "rootroot";

    private Util(){

    }

    public static Connection getConnection() throws SQLException {
        return getConnection(hostName, dbName, userName, password);
    }

    public static Connection getConnection(String hostName, String dbName,
                                           String userName, String password) throws SQLException {

        String url = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        return DriverManager.getConnection(url, userName, password);
    }

    public static SessionFactory getHibernateConnection() {
        return getHibernateConnection(hostName, dbName, userName, password);
    }

    public static SessionFactory getHibernateConnection(String hostName, String dbName,
                                                        String userName, String password){

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
