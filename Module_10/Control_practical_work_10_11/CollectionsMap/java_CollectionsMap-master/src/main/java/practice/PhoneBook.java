package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, String> phoneBookList = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (isPhone(phone) && isName(name)) {
            phoneBookList.put(phone, name);
        }
    }

    public String getContactByPhone(String phone) {
        return phoneBookList.get(phone) + " - " + phone;
    }

    public Set<String> getContactsByName(String name) {
        Set<String> contacts = new TreeSet<>();
        List<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> entry : phoneBookList.entrySet()) {
            if (entry.getValue().equals(name)) {
                phones.add(entry.getKey());
            }
        }
        contacts.add(name + " - " + String.join(", ", phones));
        return contacts;
    }

    public Set<String> getAllContacts() {
        Set<String> contacts = new TreeSet<>();
        Set<String> phones;
        Map<String, Set<String>> namePhonesOrder = new TreeMap<>();

        for (Map.Entry<String, String> entry : phoneBookList.entrySet()) {
            if (namePhonesOrder.containsKey(entry.getValue())) {
                phones = namePhonesOrder.get(entry.getValue());
            } else {
                phones = new TreeSet<>();
            }
            phones.add(entry.getKey());
            namePhonesOrder.put(entry.getValue(), phones);
        }

        for (Map.Entry<String, Set<String>> entry : namePhonesOrder.entrySet()) {
            contacts.add(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }

        return contacts;
    }

    public boolean isName(String name) {
        Matcher matcher = Pattern.compile("[А-Я][а-яё]+").matcher(name.trim());
        return matcher.matches();
    }

    public boolean isPhone(String phone) {
        Matcher matcher = Pattern.compile("79\\d{9}").matcher(phone);
        return matcher.matches();
    }

    public void phoneBookStart() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            if (this.isName(input)) {
                selectActionToEnterName(input);
            } else if (this.isPhone(input)) {
                selectActionToEnterPhone(input);
            } else if (input.equalsIgnoreCase("LIST")) {
                for (String contact : this.getAllContacts()) {
                    System.out.println(contact);
                }
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }

    private void selectActionToEnterPhone(String phone) {
        if (this.phoneBookList.containsKey(phone)) {
            System.out.println(this.getContactByPhone(phone));
        } else {
            System.out.println("Такого номера нет в телефонной книге. Введите имя абонента для номера: \""
                    + phone + "\"");
            enterNameForNewSubscriber(phone);
        }
    }

    private void enterNameForNewSubscriber(String phone) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (this.isName(input)) {
            this.addContact(phone, input);
            System.out.println("Контакт сохранен!");
        } else {
            System.out.println("Неверный формат имени абонента. Введите имя абонента для номера телефона: \""
                    + phone + "\"");
            enterNumberForNewSubscriber(phone);
        }
    }

    private void selectActionToEnterName(String name) {
        if (this.phoneBookList.containsValue(name)) {
            for (String s : this.getContactsByName(name)) {
                System.out.println(s);
            }
        } else {
            System.out.println("Такого имени нет в телефонной книге. Введите номер телефона для абонента: \""
                    + name + "\"");
            enterNumberForNewSubscriber(name);
        }
    }

    private void enterNumberForNewSubscriber(String name) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (this.isPhone(input)) {
            this.addContact(input, name);
            System.out.println("Контакт сохранен!");
        } else {
            System.out.println("Неверный формат номера телефона. Введите номер телефона для абонента: \""
                    + name + "\"");
            enterNumberForNewSubscriber(name);
        }
    }
}