package practice;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    Map<String, String> phoneBookList = new TreeMap<>();
    Map<String, Set<String>> namePhoneOrder = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (isPhone(phone) && isName(name)) {
            phoneBookList.put(phone, name);
            if (!namePhoneOrder.containsKey(name)) {
                namePhoneOrder.put(name, new TreeSet<>());
                namePhoneOrder.get(name).add(phone);
            } else {
                namePhoneOrder.get(name).add(phone);
            }
        }
    }

    public Map<String, Set<String>> getNamePhoneOrder() {
        return namePhoneOrder;
    }

    public String getContactByPhone(String phone) {
        return phoneBookList.get(phone) + " - " + phone;
    }

    public Set<String> getContactsByName(String name) {
        Set<String> setContacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBookList.entrySet()) {
            if (entry.getValue().equals(name)) {
                setContacts.add(name + " - " + entry.getKey());
            }
        }
        return setContacts;
    }

    public Set<String> getAllContacts() {
        Set<String> contacts = new TreeSet<>();

        for (Map.Entry<String, Set<String>> entry : namePhoneOrder.entrySet()) {
            contacts.add(entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }

        return contacts;
    }

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
}