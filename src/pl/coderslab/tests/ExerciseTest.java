package pl.coderslab.tests;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

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
        for (int i = 0; i < exercises.length; i++) {
            System.out.println(exercises[i]);
        }

        System.out.println(exerciseDao.read(4));
    }


}
