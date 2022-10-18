package org.example;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        System.out.println(getPeriodFromJavaBirthday());
    }

    public static String getPeriodFromJavaBirthday() {
        LocalDate now = LocalDate.now();
        LocalDate javaBirthday = LocalDate.of(1995, 5, 23);

        Period period = javaBirthday.until(now);

        return period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days";
    }
}