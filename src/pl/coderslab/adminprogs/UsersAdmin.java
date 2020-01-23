package pl.coderslab.adminprogs;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;
import pl.coderslab.util.Statements;

import java.util.Scanner;

public class UsersAdmin {


    private static User readUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj imię i nazwisko: ");
        String name = scan.nextLine();
        System.out.println("Podaj adres e-mail: ");
        String email = scan.next();
        System.out.println("Podaj hasło: ");
        String password = scan.next();
        System.out.println("Podaj id grupy: ");
        while (!scan.hasNextInt()) {
            System.out.println("Id grupy musi być liczbą naturalną!");
            scan.next();
        }
        int groupId = scan.nextInt();

        User user = new User(1, name, email, password, groupId);
        return user;
    }

    private static int readUserId() {
        System.out.println("Podaj id użytkownika: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Id użytkownika musi być liczbą naturalną!");
            scan.next();
        }
        return scan.nextInt();
    }

    private static void addUser() {
        System.out.println("Wybrano dodanie użytkownika.");
        UserDao userDao = new UserDao();
        userDao.create(readUser());
    }

    private static void editUser() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Wybrano edycję danych użytkownika.");
        int userId = readUserId();
        UserDao userDao = new UserDao();
        System.out.println("Czy zmienić dane użytkownika: Tak lub Nie");
        System.out.println(userDao.read(userId));
        String yesOrNo = scan.next();

        if (yesOrNo.toLowerCase().equals("tak")) {
            System.out.println("Wpisz nowe dane użytkownika: ");
            User newUser = readUser();
            newUser.setId(userId);
            userDao.update(newUser);

        } else if (yesOrNo.toLowerCase().equals("nie")) {
            System.out.println("Nie edytujemy użytkownika. Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }

    public static void deleteUser() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Wybrano usunięcie użytkownika.");
        int userId = readUserId();
        UserDao userDao = new UserDao();
        System.out.println("Czy usunąć użytkownika? Wpisz tak lub nie.");
        System.out.println(userDao.read(userId));
        String yesOrNo = scan.next();
        if (yesOrNo.toLowerCase().equals("tak")) {
            userDao.delete(userId);
            System.out.println("Użytkownik usunięty.");
        } else if (yesOrNo.toLowerCase().equals("nie")) {
            System.out.println("Nie usuwamy użytkownika. Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }

    public static void addEditOrDeleteUser(){
        Statements.showStatements("Wybierz jedną z opcji:", "-> add - dodanie użytkownika,",
                "-> edit - edycja użytkownika,", "-> delete - usunięcie użytkownia,", "-> quit - zakończenie programu.");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        // nextLine widzi i zjada Enter, a next nie!!!!
        if (str.equals("add")) {
            addUser();
        } else if (str.equals("edit")) {
            editUser();
        } else if (str.equals("delete")) {
            deleteUser();
        } else if (str.equals("quit")) {
            System.out.println("Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej z opcji. Koniec programu.");
        }
    }

}
