package pl.coderslab;

import pl.coderslab.dao.SkillDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.Skill;
import pl.coderslab.model.UserGroup;

public class SkillTest {

    public static void main(String[] args) {

        Skill skill = new Skill(1, "Zdolności ponadprogramowe");
        SkillDao skillDao = new SkillDao();
        skill.setSkill("Zdolności niebotyczne");
        //skill.setId(9);
        //skill.setSkill("Nieboskie zdolności");
        //skillDao.update(skill);
        //skillDao.create(skill);
        skillDao.delete(9);
        Skill[] skills = skillDao.findAll();
        try {
            int i = 0;
            while (skills[i] != null) {
                System.out.println(skills[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }

        System.out.println(skillDao.read(4));
    }
}
