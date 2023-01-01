package practice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
        Set<String> names = new TreeSet<>(phoneBookList.values());
        List<String> phones = new ArrayList<>();

        for (String s : names) {
            for (Map.Entry<String, String> entry : phoneBookList.entrySet()) {
                if (entry.getValue().equals(s)) {
                    phones.add(entry.getKey());
                }
            }
            contacts.add(s + " - " + String.join(", ", phones));
            phones.clear();
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
}