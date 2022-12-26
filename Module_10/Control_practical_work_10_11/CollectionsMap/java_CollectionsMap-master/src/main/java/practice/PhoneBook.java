package practice;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, Set<String>> phoneBookList = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        boolean containPhone = false;
        boolean needRemove = false;
        for (Map.Entry<String, Set<String>> entry : phoneBookList.entrySet()) {
            for (String s : entry.getValue()) {
                if (s.equals(phone)) {
                    containPhone = true;
                }
            }
        }

        if (isValidName(name) && isValidPhone(phone) && !phoneBookList.containsKey(name) && !containPhone) {
            phoneBookList.put(name, new TreeSet<>());
            phoneBookList.get(name).add(phone);
        } else if (isValidName(name) && isValidPhone(phone) && !phoneBookList.containsKey(name) && containPhone) {
            for (Map.Entry<String, Set<String>> entry : phoneBookList.entrySet()) {
                Set<String> currentSetPhones = entry.getValue();
                for (String s : currentSetPhones) {
                    if (s.equals(phone) && currentSetPhones.size() > 1) {
                        phoneBookList.get(entry.getKey()).remove(phone);
                    } else if (s.equals(phone) && currentSetPhones.size() == 1) {
                        needRemove = true;
                    }
                }
                if (needRemove) {
                    phoneBookList.remove(entry.getKey());
                }
            }
            Set<String> phones = new TreeSet<>();
            phones.add(phone);
            phoneBookList.put(name, phones);
        }
        else if (isValidName(name) && isValidPhone(phone) && phoneBookList.containsKey(name)) {
            phoneBookList.get(name).add(phone);
        }
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String contactByPhone = "";

        for (Map.Entry<String, Set<String>> entry : phoneBookList.entrySet()) {
            for (String s : entry.getValue()) {
                if (s.equals(phone)) {
                    contactByPhone = entry.getKey() + " - " + String.join(",", entry.getValue());
                }
            }
        }

        return contactByPhone;
    }

    public Set<String> getContactsByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        Set<String> contactByName = new TreeSet<>();
        contactByName.add(name + " - " + String.join(",", phoneBookList.get(name)));
        return contactByName;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> contactsList = new TreeSet<>();
        String result;
        for (Map.Entry<String, Set<String>> entry : phoneBookList.entrySet()) {
            result = entry.getKey() + " - ";
            Set<String> values = entry.getValue(); // получения ключа
            result += String.join(", ", values);
            contactsList.add(result);
        }
        return contactsList;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */

    private boolean isValidName(String name) {
        Pattern validName = Pattern.compile("[А-Я][а-я]+");
        Matcher matcher = validName.matcher(name);
        return matcher.matches();
    }

    private boolean isValidPhone(String phone) {
        Pattern validNumber = Pattern.compile("79\\d{9}");
        Matcher matcher = validNumber.matcher(phone);
        return matcher.matches();
    }

}