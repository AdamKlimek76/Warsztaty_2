package pl.coderslab;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;

public class UserGroupTest {

    public static void main(String[] args) {

        UserGroup userGroup = new UserGroup(1, "Grupa D");
        UserGroupDao userGroupDao = new UserGroupDao();
        userGroup.setName("Grupa DDD");
        //userGroup.setId(7);
        //userGroupDao.update(userGroup);
        //userGroupDao.create(userGroup);
        userGroupDao.delete(7);
        UserGroup[] userGroups = userGroupDao.findAll();
        try {
            int i = 0;
            while (userGroups[i] != null) {
                System.out.println(userGroups[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }

        System.out.println(userGroupDao.read(4));
    }
}
