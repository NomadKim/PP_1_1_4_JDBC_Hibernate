package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable(){
            try (Connection connection = Util.getConnection()) {
                Statement statement = connection.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS Users(id int NOT NULL AUTO_INCREMENT, firstName varchar(255), " +
                        "lastName varchar(255), age smallint, PRIMARY KEY (id))";
                statement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void dropUsersTable() {
            try (Connection connection = Util.getConnection()) {
                Statement statement = connection.createStatement();
                statement.execute("DROP TABLE IF EXISTS Users");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void saveUser(String name, String lastName, byte age) {
        try(Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            String sql = String.format("INSERT INTO Users (firstName, lastName, age) VALUES ( '%s', '%s', '%s' );",
                    name, lastName, String.valueOf(age));
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try(Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Users WHERE id =" + id;
            boolean a = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> listOfUsers= new ArrayList<>();
        try(Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users";
            ResultSet a = statement.executeQuery(sql);
            while(a.next()){
                User newUser = new User(a.getString("firstName"), a.getString("lastName"),
                        a.getByte("age"));
                newUser.setId(a.getLong("id"));
                 listOfUsers.add(newUser);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfUsers;
    }

    public void cleanUsersTable() {
        try(Connection connection = Util.getConnection()){
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Users";
            boolean a = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
