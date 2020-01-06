package pl.coderslab.adminprogs;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import java.util.Scanner;

public class ExercisesAdmin {

    public static void main(String[] args) {
        System.out.println("Wybierz jedną z opcji:");
        System.out.println("-> add - dodanie zadania,");
        System.out.println("-> edit - edycja zadania,");
        System.out.println("-> delete - usunięcie zadania,");
        System.out.println("-> quit - zakończenie programu.");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.equals("add")) {
            System.out.println("Wybrano dodanie zadania.");
            ExerciseDao exerciseDao = new ExerciseDao();
            exerciseDao.create(setExercise());

        } else if (str.equals("edit")) {
            System.out.println("Wybrano edycję zadania.");
            int exerciseId = setExerciseId();
            ExerciseDao exerciseDao = new ExerciseDao();
            System.out.println("Czy zmienić dane zadanie: Tak lub Nie");
            System.out.println(exerciseDao.read(exerciseId));
            String yesOrNo = scan.next();

            if (yesOrNo.toLowerCase().equals("tak")) {
                System.out.println("Wpisz nowe dane zadania: ");
                Exercise newExercise = setExercise();
                newExercise.setId(exerciseId);
                exerciseDao.update(newExercise);
            } else if (yesOrNo.toLowerCase().equals("nie")) {
                System.out.println("Nie edytujemy zadania. Koniec programu.");
            } else {
                System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
            }


        } else if (str.equals("delete")) {
            System.out.println("Wybrano usunięcie zadania.");
            int exerciseId = setExerciseId();
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

        } else if (str.equals("quit")) {
            System.out.println("Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej z opcji. Koniec programu.");
        }
    }

    private static Exercise setExercise() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj tytuł zadania ");
        String title = scan.nextLine();
        System.out.println("Podaj opis zadania: ");
        String description = scan.nextLine();
        Exercise exercise = new Exercise(1, title, description);
        return exercise;
    }

    private static int setExerciseId() {
        System.out.println("Podaj id zadania: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Id zadania musi być liczbą naturalną!");
            scan.next();
        }
        return scan.nextInt();
    }

}
