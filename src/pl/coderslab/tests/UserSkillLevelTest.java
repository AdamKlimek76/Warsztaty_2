package pl.coderslab.tests;

import pl.coderslab.dao.UserSkillLevelDao;
import pl.coderslab.model.UserSkillLevel;

public class UserSkillLevelTest {

    public static void main(String[] args) {

        UserSkillLevel userSkillLevel = new UserSkillLevel(9, 10, 4, 5);
        UserSkillLevelDao userSkillLevelDao = new UserSkillLevelDao();
        //userSkillLevel.setSkillId(1);
        //userSkillLevel.setLevelId(4);
        //userSkillLevelDao.update(userSkillLevel);
        //userSkillLevelDao.create(userSkillLevel);
        userSkillLevelDao.delete(9);
        UserSkillLevel[] userSkillLevels = userSkillLevelDao.findAll();
        for (int i = 0; i < userSkillLevels.length; i++) {
            System.out.println(userSkillLevels[i]);
        }

        System.out.println(userSkillLevelDao.read(9));
    }
}
