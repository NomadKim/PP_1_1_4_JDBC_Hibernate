package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
        userDaoJDBCImpl.createUsersTable();

        User userOne = new User("Dow", "Jones", (byte)34);
        userDaoJDBCImpl.saveUser(userOne.getName(), userOne.getLastName(), userOne.getAge());
        System.out.println("User с именем – " + userOne.getName() + " добавлен в базу данных ");

        User userTwo = new User("Dow", "Jones", (byte)34);
        userDaoJDBCImpl.saveUser(userTwo.getName(), userTwo.getLastName(), userTwo.getAge());
        System.out.println("User с именем – " + userTwo.getName() + " добавлен в базу данных ");

        User userThree = new User("Dow", "Jones", (byte)34);
        userDaoJDBCImpl.saveUser(userThree.getName(), userThree.getLastName(), userThree.getAge());
        System.out.println("User с именем – " + userThree.getName() + " добавлен в базу данных ");

        User userFour = new User("Dow", "Jones", (byte)34);
        userDaoJDBCImpl.saveUser(userFour.getName(), userFour.getLastName(), userFour.getAge());
        System.out.println("User с именем – " + userFour.getName() + " добавлен в базу данных ");

        List<User> listUsers = userDaoJDBCImpl.getAllUsers();
        for (User i : listUsers){
            System.out.println(i.toString());
        }

        userDaoJDBCImpl.cleanUsersTable();
        userDaoJDBCImpl.dropUsersTable();

    }
}
