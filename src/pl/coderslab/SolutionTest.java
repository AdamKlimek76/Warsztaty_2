package pl.coderslab;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SolutionTest {
    public static void main(String[] args) {

        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime createdDate=LocalDateTime.parse("2019-12-12 21:00", format);
        java.sql.Timestamp created = Timestamp.valueOf(createdDate);
        LocalDateTime updatedDate=LocalDateTime.parse("2019-12-14 22:00", format);
        Timestamp updated=Timestamp.valueOf(updatedDate);
        Timestamp date=Timestamp.valueOf("2019-12-15 12:00:00");
        System.out.println(date);

        Solution solution = new Solution(1,created, updated,
                "Opis rozwiązania testowego", 3, 11);
        SolutionDao solutionDao = new SolutionDao();
        solution.setUpdated(date);
        solution.setId(5);
        solution.setDescription("Zmieniony opis zadania");
        solutionDao.update(solution);
        //solutionDao.create(solution);
        solutionDao.delete(5);
        Solution[] solutions = solutionDao.findAll();
        try {
            int i = 0;
            while (solutions[i] != null) {
                System.out.println(solutions[i]);
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("");
        }

        System.out.println(solutionDao.read(3));
    }



}
