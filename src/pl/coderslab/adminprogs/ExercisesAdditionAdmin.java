package pl.coderslab.adminprogs;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;
import pl.coderslab.util.DateTime;
import pl.coderslab.util.Statements;

import java.sql.Timestamp;
import java.util.Scanner;

public class ExercisesAdditionAdmin {


    public static void addExerciseSolutionByUserId() {

        Scanner scan = new Scanner(System.in);
        Statements.showStatements("Wybrano przypisanie zadadania do użytkownika.",
                "Lista wszystkich użytkowników:");
        UserDao userDao = new UserDao();
        User[] users = userDao.findAll();
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i]);
        }
        Statements.showStatements("", "Podaj id użytkownika, którego rozwiązanie chcesz dodać:");
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
        Statements.showStatements("", "Wybierz id zadania, do którego chcesz dodać rozwiązanie.");
        while (!scan.hasNextInt()) {
            System.out.println("Id zadania musi być liczbą naturalną!");
            scan.next();
        }
        int exerciseId = scan.nextInt();
        scan.nextLine();
        System.out.println("Podaj rozwiązanie zadania: ");
        String description = scan.nextLine();
        Timestamp created = DateTime.createTimestampNow();
        Solution solution=new Solution(1, created, null, description, exerciseId, userId);
        SolutionDao solutionDao = new SolutionDao();
        solutionDao.create(solution);

    }

    public static void viewExerciseSolutionsByUserId(){

        Scanner scan = new Scanner(System.in);
        Statements.showStatements("Wybrano przeglądanie rozwiązań zadań danego użytkownika",
                "Podaj id użytkownika");
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
    }

    public static void addOrViewExerciseSolutionsByUserId(){
        Statements.showStatements("Wybierz jedną z opcji:", "-> add - przypisywanie zadań do użytkowników,",
                "-> view - przeglądanie rozwiązań danego użytkownika,", "-> quit - zakończenie programu.");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.equals("add")) {
            addExerciseSolutionByUserId();
        } else if (str.equals("view")) {
            viewExerciseSolutionsByUserId();
        } else if (str.equals("quit")) {
            System.out.println("Koniec programu");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }


}
