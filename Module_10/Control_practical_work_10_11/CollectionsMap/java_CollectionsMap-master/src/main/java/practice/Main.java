package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String name;
            String phone;

            if (input.equals("0")) {
                break;
            }

            if (phoneBook.isValidName(input) && phoneBook.phoneBookList.containsKey(input)) {
                name = input;
                System.out.println("Имя абонента " + "\"" + name + "\"" + "уже есть в телефонной книге. "
                        + "Введите другое имя, номер или команду:");
                input = scanner.nextLine();
            }

            if (phoneBook.isValidName(input) && !phoneBook.phoneBookList.containsKey(input)) {
                name = input;
                System.out.println("Такого имени в телефонной книге нет. "
                        .concat("Введите номер телефона для абонента ")
                        .concat("\"")
                        .concat(name)
                        .concat("\":"));
                input = scanner.nextLine();
                if (phoneBook.isValidPhone(input)) {
                    phone = input;
                    phoneBook.addContact(phone, name);
                } else {
                    while (!phoneBook.isValidPhone(input)) {
                        System.out.println("Неверный формат ввода номера телефона. "
                                .concat("Введите номер телефона для абонента ")
                                .concat("\"")
                                .concat(input)
                                .concat("\":"));
                        input = scanner.nextLine();
                    }
                    phone = input;
                    phoneBook.addContact(phone, name);
                    System.out.println("Контакт сохранен!");
                }
            } else if (phoneBook.isValidPhone(input)) {
                phone = input;
                System.out.println("Такого номера в телефонной книге нет. "
                        .concat("Введите имя абонента для номера ")
                        .concat("\"")
                        .concat(phone)
                        .concat("\":"));
                input = scanner.nextLine();
                if (phoneBook.isValidName(input)) {
                    name = input;
                    phoneBook.addContact(phone, name);
                } else {
                    while (!phoneBook.isValidName(input)) {
                        System.out.println("Неверный формат ввода имени абонента. "
                                .concat("Введите имя абонента для номера ")
                                .concat("\"")
                                .concat(phone)
                                .concat("\":"));
                        input = scanner.nextLine();
                    }
                    name = input;
                    phoneBook.addContact(phone, name);
                    System.out.println("Контакт сохранен!");
                }
            } else if (input.equals("LIST")) {
                for (String contact : phoneBook.getAllContacts()) {
                    System.out.println(contact);
                }
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }
}
