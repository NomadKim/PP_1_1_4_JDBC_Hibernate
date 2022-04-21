package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userDao = new UserServiceImpl();

        userDao.createUsersTable();

        User userOne = new User("Dow", "Jones", (byte)34);
        userDao.saveUser(userOne.getName(), userOne.getLastName(), userOne.getAge());
        System.out.println("User с именем – " + userOne.getName() + " добавлен в базу данных ");

        User userTwo = new User("Dow", "Jones", (byte)34);
        userDao.saveUser(userTwo.getName(), userTwo.getLastName(), userTwo.getAge());
        System.out.println("User с именем – " + userTwo.getName() + " добавлен в базу данных ");

        User userThree = new User("Dow", "Jones", (byte)34);
        userDao.saveUser(userThree.getName(), userThree.getLastName(), userThree.getAge());
        System.out.println("User с именем – " + userThree.getName() + " добавлен в базу данных ");

        User userFour = new User("Dow", "Jones", (byte)34);
        userDao.saveUser(userFour.getName(), userFour.getLastName(), userFour.getAge());
        System.out.println("User с именем – " + userFour.getName() + " добавлен в базу данных ");

        List<User> listUsers = userDao.getAllUsers();
        for (User i : listUsers){
            System.out.println(i.toString());
        }

        userDao.cleanUsersTable();
        userDao.dropUsersTable();


    }
}
