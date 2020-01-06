package pl.coderslab.tests;

import pl.coderslab.dao.UserGroupDao;
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
        for (int i = 0; i < userGroups.length; i++) {
            System.out.println(userGroups[i]);
        }

        System.out.println(userGroupDao.read(4));
    }

}
