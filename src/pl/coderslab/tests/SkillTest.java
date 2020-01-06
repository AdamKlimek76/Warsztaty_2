package pl.coderslab.tests;

import pl.coderslab.dao.SkillDao;
import pl.coderslab.model.Skill;

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
        for (int i = 0; i < skills.length; i++) {
            System.out.println(skills[i]);
        }

        System.out.println(skillDao.read(4));
    }
}
