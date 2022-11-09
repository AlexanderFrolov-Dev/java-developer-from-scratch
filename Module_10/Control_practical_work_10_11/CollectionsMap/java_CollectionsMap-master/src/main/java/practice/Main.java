package practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Гоша - 79001234567
//        Гриша - 79011234567
//        Маша - 79021234567 79051234567
//        Миша - 79031234567
//        Паша - 79041234567
//        LIST
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            if (phoneBook.isPhone(input)) {
                System.out.println("Такого номера в телефонной книге нет. "
                        .concat("Введите имя абонента для номера ")
                        .concat("\"")
                        .concat(input)
                        .concat("\":"));
                String name = scanner.nextLine();
                if (phoneBook.isName(name)) {
                    phoneBook.addContact(input, name);
                    System.out.println("Контакт сохранен!");
                }
            } else if (phoneBook.isName(input)) {
                System.out.println("Такого имени в телефонной книге нет. "
                        .concat("Введите номер телефона для абонента ")
                        .concat("\"")
                        .concat(input)
                        .concat("\":"));
                String phone = scanner.nextLine();
                if (phoneBook.isPhone(phone)) {
                    phoneBook.addContact(phone, input);
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
