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
                        System.out.println("Добавлено дело \""
                                .concat(getCase(commandElements))
                                .concat("\""));
                    }
                    break;
                case ("EDIT"):
                    String oldCase = todoList.getTodos().get(Integer.parseInt(commandElements[1]));
                    todoList.edit(Integer.parseInt(commandElements[1]), getCase(commandElements));
                    System.out.println("Дело \""
                            .concat(oldCase)
                            .concat("\"")
                            .concat(" заменено на \"")
                            .concat(getCase(commandElements))
                            .concat("\""));
                    break;
                case ("LIST"):
                    for (int i = 0; i < todoList.getTodos().size(); i++) {
                        System.out.print(i + " - " + todoList.getTodos().get(i) + System.lineSeparator());
                    }
                    break;
                case ("DELETE"):
                    if (Integer.parseInt(commandElements[1]) < todoList.getTodos().size()) {
                        String oldValue = todoList.getTodos().get(Integer.parseInt(commandElements[1]));
                        todoList.delete(Integer.parseInt(commandElements[1]));
                        System.out.println("Дело \"".concat(oldValue).concat("\" удалено"));
                    } else {
                        System.out.println("Дело с таким номером не существует");
                    }

            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
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
