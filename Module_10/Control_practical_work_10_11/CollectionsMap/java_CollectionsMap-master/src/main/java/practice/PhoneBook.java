package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<String> namesList = new ArrayList<>(phoneBookList.values());
        Set<String> names = new TreeSet<>(phoneBookList.values());
        Set<String> phones;
        String result = "";
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

//        for (Map.Entry<String, String> entry : phoneBookList.entrySet()) {
//            if (namePhonesOrder.containsKey(entry.getValue())) {
//                phones = namePhonesOrder.get(entry.getValue());
//            } else {
//                phones = new TreeSet<>();
//            }
//            phones.add(entry.getKey());
//            namePhonesOrder.put(entry.getValue(), phones);
//        }
//
//        for (Map.Entry<String, Set<String>> entry : namePhonesOrder.entrySet()) {
//            contacts.add(entry.getKey() + " - " + String.join(", ", entry.getValue()));
//        }

//        for (Map.Entry<String, String> entry : phoneBookList.entrySet()) {
//            result = entry.getValue() + " - " + entry.getKey();
//            if (contacts.contains(result)) {
//                contacts.remove(result);
//                result += result + ", " + entry.getKey();
//                contacts.add(result);
//            } else {
//                contacts.add(result);
//            }
//        }
//            contacts.add(s + " - " + String.join(", ", phones));
//        phones.clear();


//        for (String s : names) {
//            for (Map.Entry<String, String> entry : phoneBookList.entrySet()) {
//                if (entry.getValue().equals(s)) {
//                    phones.add(entry.getKey());
//                }
//            }
//            contacts.add(s + " - " + String.join(", ", phones));
//            phones.clear();
//        }

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
}