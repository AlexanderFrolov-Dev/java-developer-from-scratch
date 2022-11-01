package practice;

import java.util.Scanner;

public class Main {
    /*
    ADD buy milk
    ADD learn java
    LIST
     */
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        System.out.println("Введите команду:");

        while (true) {
            String input = new Scanner(System.in).nextLine();
            String[] words = input.split(" ");

            switch (words[0]) {
                case ("ADD"):
                    todoList.add(input.substring(input.indexOf(' ') + 1));
                    System.out.println("Добавлено дело \"" + input.substring(input.indexOf(' ') + 1) + "\"");
                    break;
                case ("EDIT"):
//                    System.out.println("EDIT"
//                            + words[1]
//                            + todoList.edit(Integer.parseInt(words[1]), input.substring(input.indexOf(' ') + 1).substring(input.indexOf(' ')))
//                            + input.substring(input.indexOf(' ') + 1).substring(input.indexOf(' ')));
                    break;
                case ("LIST"):
                    for (int i = 0; i < todoList.getTodos().size(); i++) {
                        System.out.println(i + " - " + todoList.getTodos().get(i));
                    }
                    break;
                case ("DELETE"):
                    System.out.println("Дело " + "\"" + input.substring(input.indexOf(' ') + 1).substring(input.indexOf(' ')) + "\"");
            }
        }
        // TODO: написать консольное приложение для работы со списком дел todoList
    }
}
