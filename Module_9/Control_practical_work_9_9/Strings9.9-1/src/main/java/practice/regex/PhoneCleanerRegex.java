package practice.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneCleanerRegex {
    public static void main(String[] args) {
        /*
        Группы в регулярном выражении:
            $1 - (\+?)
            $2 - (\D*)
            $3 - ([0-9]?)
            $4 - (\D*)
            $5 - (9([0-9]{2}))
            $6 - ([0-9]{2}) - группа 5 является вложенной в группе 6
            $7 - (\D*)
            $8 - ([0-9]{3})
            $9 - (\D*)
            $10 - ([0-9]{2})
            $11 - (\D*)
            $12 - ([0-9]{2})
         */
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
                correctPhoneNumber = matcher.replaceFirst("7$5$8$10$12");
            } else {
                correctPhoneNumber = "Неверный формат номера";
            }

            System.out.println(correctPhoneNumber);
        }
    }
}
