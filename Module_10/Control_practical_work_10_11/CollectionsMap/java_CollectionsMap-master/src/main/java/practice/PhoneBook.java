package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();
    Map<String, String> namePhoneOrder = new TreeMap<>();
    Map<String, Set<String>> namePhone = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (isPhone(phone) && isName(name)) {
            phoneBook.put(phone, name);
        }

        if (phoneBook.containsKey(phone)) {
            phoneBook.put(phone, name);
        }
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return phoneBook.get(phone) + " - " + phone;
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        Set<String> setContacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                setContacts.add(name + " - " + entry.getKey());
            }
        }
        return setContacts;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> contacts = new TreeSet<>();

//        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
//            addElementInNamePhoneOrder(entry);
//        }

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            namePhone.put(entry.getValue(), getContactByName(entry.getValue()));
        }

        for (Map.Entry<String, Set<String>> entry : namePhone.entrySet()) {
            String[] array = new String[entry.getValue().size()];
            String[] subscriberNumbers = entry.getValue().toArray(array);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subscriberNumbers.length; i++) {
                if (i < entry.getValue().size() - 1) {
                    sb.append(subscriberNumbers[i]).append(", ");
                    System.out.println("not last: " + sb);
                } else {
                    sb.append(subscriberNumbers[i]);
                    System.out.println("last: " + sb);
                }
            }
            contacts.add(entry.getKey() + " - " + sb);
        }

//        for (Map.Entry<String, String> entry : namePhoneOrder.entrySet()) {
//            contacts.add(entry.getKey() + " - " + entry.getValue());
//        }
        return contacts;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
    public boolean isName(String name) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(name.trim());

        return matcher.matches();
    }

    public boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("79\\d{9}");
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches();
    }

//    private void addElementInNamePhoneOrder(Map.Entry<String, String> entry) {
//        if (!namePhoneOrder.containsKey(entry.getValue())) {
//            namePhoneOrder.put(entry.getValue(), entry.getKey());
//        } else {
//            namePhoneOrder.put(entry.getValue(), namePhoneOrder.get(entry.getValue()) + ", " + entry.getKey());
//        }
//    }
    private void addElementInNamePhoneOrder(Map.Entry<String, String> entry) {
        if (!namePhoneOrder.containsKey(entry.getValue())) {
            namePhoneOrder.put(entry.getValue(), entry.getKey());
        } else {
            namePhoneOrder.put(entry.getValue(), namePhoneOrder.get(entry.getValue()) + ", " + entry.getKey());
        }
    }
}
