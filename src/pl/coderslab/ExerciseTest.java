package pl.coderslab;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.UserGroup;

public class ExerciseTest {

    public static void main(String[] args) {

        Exercise exercise = new Exercise(1, "Zadanie 4", "Opis zadania 4");
        ExerciseDao exerciseDao = new ExerciseDao();
        //exercise.setTitle("Zadanie 444");
        //exercise.setDescription("Opis do zadania 444");
        //exercise.setId(4);
        //exerciseDao.update(exercise);
        //exerciseDao.create(exercise);
        exerciseDao.delete(4);
        Exercise[] exercises = exerciseDao.findAll();
        try {
            int i = 0;
            while (exercises[i] != null) {
                System.out.println(exercises[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }

        System.out.println(exerciseDao.read(4));
    }

}
