import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];

        if (components.length != 4) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (!isValidEmailFormat(components[INDEX_EMAIL])) {
            throw new InvalidEmailFormatException();
        }

        if (!isValidPhoneNumberFormat(components[INDEX_PHONE])) {
            throw new InvalidPhoneNumberFormatException();
        }

        if (!isValidNameAndSurnameFormat(name)) {
            throw new IncorrectNameFormatException();
        }

        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (!isValidNameAndSurnameFormat(name)) {
            throw new IncorrectNameFormatException();
        }

        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    private boolean isValidEmailFormat(String email) {
        Matcher matcher = Pattern.compile("[a-zA-Z\\d-+.=]+@[a-zA-Z\\d]+\\.[a-zA-Z\\d]+").matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumberFormat(String phoneNumber) {
        Matcher matcher = Pattern.compile("\\+79\\d{9}").matcher(phoneNumber);
        return matcher.matches();
    }

    private boolean isValidNameAndSurnameFormat(String nameAndSurname) {
        String[] nameAndSurnameElements = nameAndSurname.split(" ");
        String name = nameAndSurnameElements[0];
        String surname = nameAndSurnameElements[1];
        Pattern nameFormat = Pattern.compile("[А-Я][а-я]{2,}");
        Pattern surnameFormat = Pattern.compile("[А-Я][а-я]{2,}-?([А-Я][а-я]{2,})?");
        Matcher matcherName = nameFormat.matcher(name);
        Matcher matcherSurname = surnameFormat.matcher(surname);

        return nameAndSurnameElements.length == 2 && matcherName.matches() && matcherSurname.matches();
    }
}