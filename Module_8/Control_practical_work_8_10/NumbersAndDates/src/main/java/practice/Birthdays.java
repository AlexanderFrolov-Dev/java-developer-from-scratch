package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 15;
        int month = 7;
        int year = 1984;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        long age = birthday.until(currentDate, ChronoUnit.YEARS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E").localizedBy(new Locale("us"));
        String result = "";
        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue

        if (currentDate.isAfter(birthday) || currentDate.isEqual(birthday)) {
            for (long i = 0; i <= age; i++) {
                LocalDate nextBirthday = birthday.plusYears(i);
                result += i + " - " + formatter.format(nextBirthday) + "\n";
            }
        }

        return result;
    }
}
