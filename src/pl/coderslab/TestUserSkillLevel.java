package pl.coderslab;

import pl.coderslab.dao.UserSkillLevelDao;
import pl.coderslab.model.UserSkillLevel;

public class TestUserSkillLevel {

    public static void main(String[] args) {

        UserSkillLevel userSkillLevel = new UserSkillLevel(9, 10, 4, 5);
        UserSkillLevelDao userSkillLevelDao = new UserSkillLevelDao();
        //userSkillLevel.setSkillId(1);
        //userSkillLevel.setLevelId(4);
        //userSkillLevelDao.update(userSkillLevel);
        //userSkillLevelDao.create(userSkillLevel);
        userSkillLevelDao.delete(9);
        UserSkillLevel[] userSkillLevels = userSkillLevelDao.findAll();
        try {
            int i = 0;
            while (userSkillLevels[i] != null) {
                System.out.println(userSkillLevels[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }

        System.out.println(userSkillLevelDao.read(9));
    }

}
