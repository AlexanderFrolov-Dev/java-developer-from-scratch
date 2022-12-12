package practice;

import java.util.Scanner;

public class Main {
    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {
        System.out.println("Введите команду:");

        while (true) {
            String input = new Scanner(System.in).nextLine();
            String[] commandElements = input.split(" ");

            switch (commandElements[0]) {
                case ("ADD"):
                    if (isDigits(commandElements[1])) {
                        todoList.add(Integer.parseInt(commandElements[1]), getCase(commandElements));
                    } else {
                        todoList.add(getCase(commandElements));
                    }
                    break;
                case ("EDIT"):
                    todoList.edit(Integer.parseInt(commandElements[1]), getCase(commandElements));
                    break;
                case ("LIST"):
                    todoList.getTodos();
                    break;
                case ("DELETE"):
                    todoList.delete(Integer.parseInt(commandElements[1]));
            }
        }
    }

    private static boolean isDigits(String text) {
        boolean number = true;

        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                number = false;
            }
        }

        return number;
    }

    private static String getCase(String[] array) {
        StringBuilder sb = new StringBuilder();

        if (isDigits(array[1])) {
            for (int i = 2; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
        } else {
            for (int i = 1; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }
}
