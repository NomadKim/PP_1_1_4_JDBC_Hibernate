package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Users(id int NOT NULL AUTO_INCREMENT, firstName varchar(255), lastName varchar(255), age smallint, PRIMARY KEY (id))";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {

        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(SessionFactory sessionFactory = Util.getHibernateConnection()){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try(SessionFactory sessionFactory = Util.getHibernateConnection()){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> listOfUsers= new ArrayList<>();
        try(SessionFactory sessionFactory = Util.getHibernateConnection()){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            listOfUsers = session.createQuery("FROM User").list();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfUsers;
    }

    @Override
    public void cleanUsersTable() {
        try(SessionFactory sessionFactory = Util.getHibernateConnection()){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
