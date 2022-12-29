package practice;

import java.util.Scanner;

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

    private static void selectActionToEnterPhone(String phone) {
        if (phoneBook.phoneBookList.containsKey(phone)) {
            System.out.println(phoneBook.getContactByPhone(phone));
        } else {
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

    private static void selectActionToEnterName(String name) {
        if (phoneBook.phoneBookList.containsValue(name)) {
            for (String s : phoneBook.getContactsByName(name)) {
                System.out.println(s);
            }
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

}