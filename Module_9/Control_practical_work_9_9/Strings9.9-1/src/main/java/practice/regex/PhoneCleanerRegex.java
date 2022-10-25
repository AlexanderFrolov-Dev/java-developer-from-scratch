package practice.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCleanerRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctPhoneNumber;
        Pattern pattern = Pattern.compile("(\\+?)(\\D*)([0-9]?)(\\D*)(9([0-9]{2}))(\\D*)([0-9]{3})(\\D*)([0-9]{2})(\\D*)([0-9]{2})");

        while (true) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (input.equals("0")) {
                scanner.close();
                break;
            }
            if (matcher.matches()) {
                correctPhoneNumber = matcher.group().replaceAll("[\\D+]", "");
                correctPhoneNumber = correctPhoneNumber.length() == 10
                        ? "7" + correctPhoneNumber
                        : correctPhoneNumber.replaceFirst("\\d", "7");
            } else {
                correctPhoneNumber = "Неверный формат номера";
            }

            System.out.println(correctPhoneNumber);
        }
    }
}
