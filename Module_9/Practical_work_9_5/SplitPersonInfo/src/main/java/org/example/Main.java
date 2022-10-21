package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите ФИО:");
        String fio = new Scanner(System.in).nextLine();
        int firstSpaceIndex = fio.indexOf(" ");
        int lastSpaceIndex = fio.lastIndexOf(" ");
        String surname = "Фамилия: ".concat(fio.substring(0, firstSpaceIndex));
        String name = "Имя: ".concat(fio.substring(firstSpaceIndex + 1, lastSpaceIndex));
        String patronymic = "Отчество: ".concat(fio.substring(lastSpaceIndex + 1));

        System.out.println(surname.concat(System.lineSeparator())
                .concat(name).concat(System.lineSeparator())
                .concat(patronymic).concat(System.lineSeparator()));
    }
}