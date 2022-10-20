package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите первую строку:");
            Scanner scanner = new Scanner(System.in);
            String firstStr = scanner.nextLine();
            System.out.println("Введите вторую строку:");
            String secondStr = scanner.nextLine();

            System.out.println(firstStr.equalsIgnoreCase(secondStr)
                    ? firstStr.concat(" == ").concat(secondStr)
                    : firstStr.concat(" != ").concat(secondStr));
        }
    }
}