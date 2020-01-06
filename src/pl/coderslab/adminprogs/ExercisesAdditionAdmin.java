package pl.coderslab.adminprogs;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ExercisesAdditionAdmin {

    public static void main(String[] args) {
        System.out.println("Wybierz jedną z opcji:");
        System.out.println("-> add - przypisywanie zadań do użytkowników,");
        System.out.println("-> view - przeglądanie rozwiązań danego użytkownika,");
        System.out.println("-> quit - zakończenie programu.");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.equals("add")) {
            System.out.println("Wybrano przypisanie zadadania do użytkownika.");
            System.out.println("Lista wszystkich użytkowników:");
            UserDao userDao = new UserDao();
            User[] users = userDao.findAll();
            for (int i = 0; i < users.length; i++) {
                System.out.println(users[i]);
            }
            System.out.println("");
            System.out.println("Podaj id użytkownika, którego rozwiązanie chcesz dodać:");
            while (!scan.hasNextInt()) {
                System.out.println("Id użytkownika musi być liczbą naturalną!");
                scan.next();
            }
            int userId = scan.nextInt();
            System.out.println("Wybrano użytkownika: ");
            System.out.println(userDao.read(userId));
            System.out.println("Dodaj rozwiązanie użytkownika do jednego z poniższych zadań: ");
            ExerciseDao exerciseDao = new ExerciseDao();
            Exercise[] exercises = exerciseDao.findAll();
            for (int i = 0; i < exercises.length; i++) {
                System.out.println(exercises[i]);
            }
            System.out.println("");
            System.out.println("Wybierz id zadania, do którego chcesz dodać rozwiązanie.");
            while (!scan.hasNextInt()) {
                System.out.println("Id zadania musi być liczbą naturalną!");
                scan.next();
            }
            int exerciseId = scan.nextInt();
            scan.nextLine();
            System.out.println("Podaj rozwiązanie zadania: ");
            String description = scan.nextLine();
            LocalDateTime localDateTime = LocalDateTime.now();
            Timestamp created = Timestamp.valueOf(localDateTime);
            Solution solution = new Solution(1, created, null, description, exerciseId, userId);
            SolutionDao solutionDao = new SolutionDao();
            solutionDao.create(solution);

        } else if (str.equals("view")) {
            System.out.println("Wybrano przeglądanie rozwiązań zadań danego użytkownika");
            System.out.println("Podaj id użytkownika");
            while (!scan.hasNextInt()) {
                System.out.println("Id użytkownika musi być liczbą naturalną!");
                scan.next();
            }
            int userId = scan.nextInt();
            System.out.println("Lista rozwiązań zadań użytkownika o podanym id:");
            SolutionDao solutionDao = new SolutionDao();
            Solution[] solutions = solutionDao.findAllByUserId(userId);
            for (int i = 0; i < solutions.length; i++) {
                System.out.println(solutions[i]);
            }
            System.out.println("");

        } else if (str.equals("quit")) {
            System.out.println("Koniec programu");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }
}
