package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    Map<String, String> phoneBook = new TreeMap<>();
    Map<String, String> namePhoneOrder = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (phoneBook.containsKey(phone)) {
            phoneBook.put(phone, name);
        }
//        if (phoneBook.containsValue(phone)) {
//            phoneBook.put((phoneBook.get(phone).replaceAll(phoneBook.get(phone), name)), phone);
//        }

        if (isPhone(phone) && isName(name)) {
            phoneBook.put(phone, name);
        }

        // проверьте корректность формата имени и телефона
        // (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        return phoneBook.get(phone) + " - " + phone;
    }

    public Set<String> getContactByName(String name) {
        Set<String> listContacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(name)) {
                listContacts.add(name + " - " + entry.getKey());
            }
        }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        return listContacts;
    }

    public Set<String> getAllContacts() {
        Set<String> setContacts = new TreeSet<>();
//        Set<String> setNames = (TreeSet<String>) phoneBook.values();

        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            fillMap(entry);
        }

        for (Map.Entry<String, String> entry : namePhoneOrder.entrySet()) {
            setContacts.add(entry.getKey() + " - " + entry.getValue());
        }

//        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
//            setContacts.add(entry.getValue() + " - " + entry.getKey());
//        }

        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        return setContacts;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
    private boolean isName(String name) {
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(name.trim());

        return matcher.matches();
    }

    private boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile("79\\d{9}");
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches();
    }

    private void fillMap(Map.Entry<String, String> entry) {
        if (!namePhoneOrder.containsKey(entry.getValue())) {
            namePhoneOrder.put(entry.getValue(), entry.getKey());
        } else {
            namePhoneOrder.put(entry.getValue(), namePhoneOrder.get(entry.getValue()) + ", " + entry.getKey());
        }
    }
}
//        List<String> listNames = (List<String>) phoneBook.values();
//        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
//            setContacts.add(entry.getValue() + " - " + entry.getKey());
//        }

//        for (int i = 0; i < phoneBook.entrySet().size(); i++) {
//            String value = phoneBook.
//            for (int j = 0; j < phoneBook.entrySet().size(); j++) {
//                if ()
//            }
//        }
//        StringBuilder name;
//        String withMultipleNumbers = "";
//
//        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
//            name = new StringBuilder(entry.getValue() + " - ");
//            for (Map.Entry<String, String> entry1 : phoneBook.entrySet()) {
//                if (entry.getValue().equals(entry1.getValue()) && !entry.getKey().equals(entry1.getKey())) {
////                    setContacts.add(entry.getValue() + " - " + entry.getKey() + ", " + entry1.getKey());
//                    name.append(", ").append(entry.getKey());
//                }
//            }
//            setContacts.add(name.toString());
//        }