package practice;

import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    public static void main(String[] args) {
        System.out.println("Введите email:");
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true) {
            String input = scanner.nextLine();
            String[] commandElements = input.split(" ");
            if (input.equals("0")) {
                break;
            }

            if (commandElements[0].equals("ADD") && commandElements.length == 2) {
                emailList.add(commandElements[1]);
            }

            if (commandElements[0].equals("LIST") && commandElements.length == 1) {
                for (String email : emailList.getSortedEmails()) {
                    System.out.println(email);
                }
            }
        }
    }

}
