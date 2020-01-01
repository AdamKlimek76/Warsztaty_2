package pl.coderslab;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.LevelDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Level;

public class LevelTest {

    public static void main(String[] args) {

        Level level = new Level(6, 10);
        LevelDao levelDao = new LevelDao();
        //levelDao.update(level);
        //levelDao.create(level);
        levelDao.delete(6);
        Level[] levels = levelDao.findAll();
        try {
            int i = 0;
            while (levels[i] != null) {
                System.out.println(levels[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }

        System.out.println(levelDao.read(4));
    }

}
