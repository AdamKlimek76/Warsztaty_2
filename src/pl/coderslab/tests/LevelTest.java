package pl.coderslab.tests;

import pl.coderslab.dao.LevelDao;
import pl.coderslab.model.Level;

public class LevelTest {

    public static void main(String[] args) {

        Level level = new Level(6, 10);
        LevelDao levelDao = new LevelDao();
        //levelDao.update(level);
        //levelDao.create(level);
        levelDao.delete(6);
        Level[] levels = levelDao.findAll();
        for (int i = 0; i < levels.length; i++) {
            System.out.println(levels[i]);
        }

        System.out.println(levelDao.read(4));
    }

}
