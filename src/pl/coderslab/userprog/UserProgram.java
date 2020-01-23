package pl.coderslab.userprog;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;
import pl.coderslab.util.DateTime;
import pl.coderslab.util.Statements;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UserProgram {

    public static void main(String[] args) {

        System.out.println("Podaj login - email użytkownika: ");
        Scanner scan = new Scanner(System.in);
        String userEmail = scan.next();
        /* Druga opcja pobrania userEmail:
        userEmail = args[0];
         */
        UserDao userDao = new UserDao();
        User user = userDao.readUserByEmail(userEmail);
        addOrViewExercisesByUser(user);
    }

    public static void addExerciseSolutionByUserId(int userId) {
        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise[] exercisesWithSolutions = exerciseDao.findAllWithSolutionsAddedByUserWithId(userId);
        Exercise[] allExercises = exerciseDao.findAll();
        viewExercisesWithoutSolutions(allExercises, exercisesWithSolutions);

        System.out.println("Podaj id zadania, do którego chcesz dodać rozwiązanie: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Id zadania musi być liczbą naturalną!");
            scan.next();
        }
        int exerciseId = scan.nextInt();
        boolean isSolutionExist = false;
        for (int i = 0; i < exercisesWithSolutions.length; i++) {
            if (exercisesWithSolutions[i].getId() == exerciseId) {
                Statements.showStatements("Do tego zadania jest już rozwiązanie podane przez bieżącego użytkownika.",
                        "Koniec programu.");
                isSolutionExist = true;
                break;
            }
        }
        if (!isSolutionExist) {
            scan.nextLine();
            System.out.println("Podaj rozwiązanie do zadania: ");
            String description = scan.nextLine();
            Timestamp created = DateTime.createTimestampNow();
            Solution solution = new Solution(1, created, null, description, exerciseId, userId);
            SolutionDao solutionDao = new SolutionDao();
            solutionDao.create(solution);
        }
    }

    public static void viewExerciseSolutionByUserId(int userId) {
        SolutionDao solutionDao = new SolutionDao();
        Solution[] solutions = solutionDao.findAllByUserId(userId);
        for (int i = 0; i < solutions.length; i++) {
            System.out.println(solutions[i]);
        }
    }

    public static void viewExercisesWithoutSolutions(Exercise[]allExercises,
                                                     Exercise[]exercisesWithSolutions){
        Exercise[] exercisesWithoutSolutions =
                new Exercise[allExercises.length - exercisesWithSolutions.length];
        int k = 0;
        for (int i = 0; i < allExercises.length; i++) {
            boolean isSolutionExist = false;
            for (int j = 0; j < exercisesWithSolutions.length; j++) {
                if (allExercises[i].equals(exercisesWithSolutions[j])) {
                    isSolutionExist = true;
                    break;
                }
            }
            if (!isSolutionExist) {
                exercisesWithoutSolutions[k] = allExercises[i];
                k++;
            }
        }
        for (int i = 0; i < exercisesWithoutSolutions.length; i++) {
            System.out.println(exercisesWithoutSolutions[i]);
        }
    }

    public static void addOrViewExercisesByUser(User user){
        if (user == null) {
            System.out.println("Nie ma takiego użytkownika. Koniec programu!");
        } else {
            Statements.showStatements("Zalogowany użytkownik: ", user.toString(),
                    "Wybierz następujące opcje", "-> add - dodawanie rozwiązań",
                    "-> view - przeglądanie swoich rozwiązań.", "-> quit - wyjście z programu.");
            Scanner scan = new Scanner(System.in);
            String str = scan.next();
            if (str.equals("add")) {
                Statements.showStatements("Wybrano dodawanie rozwiązań",
                        "Lista zadań, do których użytkownik nie dodał jeszcze rozwiązania: ");
                int userId = user.getId();
                addExerciseSolutionByUserId(userId);
            } else if (str.equals("view")) {
                System.out.println("Wybrano przeglądanie swoich rozwiązań");
                int userId = user.getId();
                viewExerciseSolutionByUserId(userId);
            } else if (str.equals("quit")) {
                System.out.println("Koniec programu.");
            } else {
                System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
            }
        }

    }

}
