package practice;

import java.time.LocalDate;
import java.time.Period;

public class Periods {

    // реализуйте вывод разницы между датами, используя класс Period
    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {
        Period period = firstDate.until(secondDate);

        return "years:" + period.getYears() + ", months:" + period.getMonths() + ", days:" + period.getDays();
    }
}