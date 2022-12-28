package practice;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static PhoneBook phoneBook = new PhoneBook();
    static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            if (phoneBook.isName(input)) {
                selectActionToEnterName(input);
            } else if (phoneBook.isPhone(input)) {
                selectActionToEnterPhone(input);
            } else if (input.equalsIgnoreCase("LIST")) {
                for (String contact : phoneBook.getAllContacts()) {
                    System.out.println(contact);
                }
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }

    private static void selectActionToEnterName(String name) {
        if (phoneBook.getNamePhoneOrder().containsKey(name)) {
            System.out.println(name + " - " + String.join(", ", phoneBook.getNamePhoneOrder().get(name)));
        } else {
            System.out.println("Такого имени нет в телефонной книге. Введите номер телефона для абонента: \""
                    + name + "\"");
            enterNumberForNewSubscriber(name);
        }
    }

    private static void enterNumberForNewSubscriber(String name) {
        input = scanner.nextLine();
        if (phoneBook.isPhone(input)) {
            phoneBook.addContact(input, name);
            System.out.println("Контакт сохранен!");
        } else {
            System.out.println("Неверный формат номера телефона. Введите номер телефона для абонента: \""
                    + name + "\"");
            enterNumberForNewSubscriber(name);
        }
    }

    private static void selectActionToEnterPhone(String phone) {
        boolean containNumber = false;
        for (Map.Entry<String, Set<String>> entry : phoneBook.getNamePhoneOrder().entrySet()) {
            if (entry.getValue().contains(phone)) {
                containNumber = true;
                System.out.println(entry.getValue() + " - " + String.join(", ", entry.getValue()));
            }
        }

        if (!containNumber) {
            System.out.println("Такого номера нет в телефонной книге. Введите имя абонента для номера: \""
                    + phone + "\"");
            enterNameForNewSubscriber(phone);
        }
    }

    private static void enterNameForNewSubscriber(String phone) {
        input = scanner.nextLine();
        if (phoneBook.isName(input)) {
            phoneBook.addContact(phone, input);
            System.out.println("Контакт сохранен!");
        } else {
            System.out.println("Неверный формат имени абонента. Введите имя абонента для номера телефона: \""
                    + phone + "\"");
            enterNumberForNewSubscriber(phone);
        }
    }
}
