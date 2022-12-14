package practice;

import java.util.List;
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
            String command = commandElements[0];
            if (input.equals("0")) {
                break;
            }

            if (command.equals("ADD") && commandElements.length == 2) {
                emailList.add(commandElements[1]);
            }

            if (command.equals("LIST") && commandElements.length == 1) {
                List<String> emails = emailList.getSortedEmails();
                for (String email : emails) {
                    System.out.println(email);
                }
            }
        }
    }

}
