package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();
    Map<String, Set<String>> namePhoneForTest = new TreeMap<>();

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

        addAllNumbersByContact();

        for (Map.Entry<String, Set<String>> entry : namePhoneForTest.entrySet()) {
            String[] array = new String[entry.getValue().size()];
            String[] subscriberNumbers = entry.getValue().toArray(array);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subscriberNumbers.length; i++) {
                if (i < entry.getValue().size() - 1) {
                    sb.append(subscriberNumbers[i]).append(", ");
                } else {
                    sb.append(subscriberNumbers[i]);
                }
            }
            contacts.add(entry.getKey() + " - " + sb);
        }

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

    private void addAllNumbersByContact() {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            namePhoneForTest.put(entry.getValue(), new TreeSet<>());
        }

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            namePhoneForTest.get(entry.getValue()).add(entry.getKey());
        }
    }
}
