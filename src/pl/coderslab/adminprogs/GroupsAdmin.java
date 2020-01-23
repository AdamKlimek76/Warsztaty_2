package pl.coderslab.adminprogs;


import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.model.UserGroup;
import pl.coderslab.util.Statements;

import java.util.Scanner;

public class GroupsAdmin {


    private static UserGroup readGroup() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj nazwę grupy: ");
        String name = scan.nextLine();
        UserGroup userGroup = new UserGroup(1, name);
        return userGroup;
    }

    private static int readGroupId() {
        System.out.println("Podaj id grupy: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Id grupy musi być liczbą naturalną!");
            scan.next();
        }
        return scan.nextInt();
    }

    public static void addUserGroup() {
        System.out.println("Wybrano dodanie grupy.");
        UserGroupDao userGroupDao = new UserGroupDao();
        userGroupDao.create(readGroup());
    }

    public static void editUserGroup() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Wybrano edycję grupy.");
        int groupId = readGroupId();
        UserGroupDao userGroupDao = new UserGroupDao();
        System.out.println("Czy zmienić dane grupy: Tak lub Nie");
        System.out.println(userGroupDao.read(groupId));
        String yesOrNo = scan.next();

        if (yesOrNo.toLowerCase().equals("tak")) {
            System.out.println("Wpisz nowe dane grupy: ");
            UserGroup newUserGroup = readGroup();
            newUserGroup.setId(groupId);
            userGroupDao.update(newUserGroup);
        } else if (yesOrNo.toLowerCase().equals("nie")) {
            System.out.println("Nie edytujemy grupy. Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }

    public static void deleteUserGroup() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Wybrano usunięcie grupy.");
        int groupId = readGroupId();
        UserGroupDao userGroupDao = new UserGroupDao();
        System.out.println("Czy usunąć grupę? Wpisz tak lub nie.");
        System.out.println(userGroupDao.read(groupId));
        String yesOrNo = scan.next();
        if (yesOrNo.toLowerCase().equals("tak")) {
            userGroupDao.delete(groupId);
            System.out.println("Grupa usunięta.");
        } else if (yesOrNo.toLowerCase().equals("nie")) {
            System.out.println("Nie usuwamy grupy. Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej opcji. Koniec programu.");
        }
    }

    public static void addEditOrDeleteUserGroup() {
        Statements.showStatements("Wybierz jedną z opcji:", "-> add - dodanie grupy,",
                "-> edit - edycja grupy,", "-> delete - usunięcie grupy,", "-> quit - zakończenie programu.");

        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.equals("add")) {
            addUserGroup();
        } else if (str.equals("edit")) {
            editUserGroup();
        } else if (str.equals("delete")) {
            deleteUserGroup();
        } else if (str.equals("quit")) {
            System.out.println("Koniec programu.");
        } else {
            System.out.println("Nie wybrano żadnej z opcji. Koniec programu.");
        }
    }

}
