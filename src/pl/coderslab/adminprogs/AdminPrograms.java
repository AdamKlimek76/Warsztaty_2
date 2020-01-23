package pl.coderslab.adminprogs;


import pl.coderslab.util.Statements;

import java.util.Scanner;

public class AdminPrograms {

    public static void main(String[] args) {

        showMenu();

        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        while (!str.equals("quit")) {
            switch (str) {
                case "user_change":
                    UsersAdmin.addEditOrDeleteUser();
                    break;
                case "group_change":
                    GroupsAdmin.addEditOrDeleteUserGroup();
                    break;
                case "exercise_change":
                    ExercisesAdmin.addEditOrDeleteExercise();
                    break;
                case "solution_change":
                    ExercisesAdditionAdmin.addOrViewExerciseSolutionsByUserId();
                    break;
            }
            showMenu();
            str = scan.next();

        }
    }

    public static void showMenu() {
        Statements.showStatements("Wybierz następujące opcje: ",
                "Dodawanie, edycja lub usunięcie użytkowniak - user_change",
                "Dodawanie, edycja lub usunięcie grupy użytkowników - group_change",
                "Dodawanie, edycja lub usunięcie zadania - exercise_change",
                "Dodawanie lub przeglad rozwiązań do zadania po id użytkownika - solution_change",
                "Wyjście z programu - quit");
    }

}
