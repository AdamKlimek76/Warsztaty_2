package pl.coderslab.tests;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

public class UserTest {

    public static void main(String[] args) {

        User user = new User(21, "Ferenc Laszlo", "laszlo@gmail.com", "laszlo123", 5);
        UserDao userDao = new UserDao();
        //userDao.update(user);
        userDao.delete(21);
        User[] users = userDao.findAllByGroupId(4);
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }

        System.out.println(userDao.read(20));
    }

}
