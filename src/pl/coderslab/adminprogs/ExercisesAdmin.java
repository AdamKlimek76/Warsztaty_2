package pl.coderslab.adminprogs;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.util.Statements;

import java.util.Scanner;

public class ExercisesAdmin {


    private static Exercise readExercise() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj tytuł zadania ");
        String title = scan.nextLine();
        System.out.println("Podaj opis zadania: ");
        String description = scan.nextLine();
        Exercise exercise = new Exercise(1, title, description);
        return exercise;
    }

    private static int readExerciseId() {
        System.out.println("Podaj id zadania: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Id zadania musi być liczbą naturalną!");
            scan.next();
        }
        return scan.nextInt();
    }

    private static void addExercise(){
        System.out.println("Wybrano dodanie zadania.");
        ExerciseDao exerciseDao = new ExerciseDao();
        exerciseDao.create(readExercise());
    }

    private static void editExercise(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Wybrano edycję zadania.");
        int exerciseId = readExerciseId();
        ExerciseDao exerciseDao = new ExerciseDao();
        System.out.println("Czy zmienić dane zadanie: Tak lub Nie");
        System.out.println(exerciseDao.read(exerciseId));
        String yesOrNo = scan.next();

        if (yesOrNo.toLowerCase().equals("tak")) {
            System.out.println("Wpisz nowe dane zadania: ");
            Exercise newExercise = readExercise();
            newExercise.setId(exerciseId);
            exerciseDao.update(newExercise);
        } else if (yesOrNo.toLowerCase().equals("nie")) {
            System.out.println("Nie edytujemy zadania. Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }

    public static void deleteExercise(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Wybrano usunięcie zadania.");
        int exerciseId = readExerciseId();
        ExerciseDao exerciseDao = new ExerciseDao();
        System.out.println("Czy usunąć zadanie? Wpisz tak lub nie.");
        System.out.println(exerciseDao.read(exerciseId));
        String yesOrNo = scan.next();
        if (yesOrNo.toLowerCase().equals("tak")) {
            exerciseDao.delete(exerciseId);
            System.out.println("Zadanie usunięte.");
        } else if (yesOrNo.toLowerCase().equals("nie")) {
            System.out.println("Nie usuwamy zadania. Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }

    public static void addEditOrDeleteExercise(){
        Statements.showStatements("Wybierz jedną z opcji:", "-> add - dodanie zadania,",
                "-> edit - edycja zadania,", "-> delete - usunięcie zadania,", "-> quit - zakończenie programu.");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.equals("add")) {
            addExercise();
        } else if (str.equals("edit")) {
            editExercise();
        } else if (str.equals("delete")) {
            deleteExercise();
        } else if (str.equals("quit")) {
            System.out.println("Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej z opcji. Koniec programu.");
        }
    }

}
