package practice;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            if (phoneBook.isValidPhone(input)) {
                System.out.println("Такого номера в телефонной книге нет. "
                        .concat("Введите имя абонента для номера ")
                        .concat("\"")
                        .concat(input)
                        .concat("\":"));
                String name = scanner.nextLine();
                if (phoneBook.isValidName(name)) {
                    phoneBook.addContact(name, input);
                    System.out.println("Контакт сохранен!");
                }
            } else if (phoneBook.isValidName(input)) {
                System.out.println("Такого имени в телефонной книге нет. "
                        .concat("Введите номер телефона для абонента ")
                        .concat("\"")
                        .concat(input)
                        .concat("\":"));
                String phone = scanner.nextLine();
                if (phoneBook.isValidPhone(phone)) {
                    phoneBook.addContact(input, phone);
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