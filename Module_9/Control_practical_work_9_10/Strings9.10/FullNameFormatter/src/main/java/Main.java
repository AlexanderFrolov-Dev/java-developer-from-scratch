import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            int firstSpaceIndex = input.indexOf(" ");
            int lastSpaceIndex = input.lastIndexOf(" ");

            if (calculateNumberOfSpaces(input) == 2 && validSymbols(input)) {
                String surname = "Фамилия: ".concat(input.substring(0, firstSpaceIndex));
                String name = "Имя: ".concat(input.substring(firstSpaceIndex + 1, lastSpaceIndex));
                String patronymic = "Отчество: ".concat(input.substring(lastSpaceIndex + 1));

                System.out.println(surname.concat(System.lineSeparator())
                        .concat(name).concat(System.lineSeparator())
                        .concat(patronymic));
            } else {
                System.out.println("Введенная строка не является ФИО");
            }
        }
    }

    private static boolean validSymbols(String text) {
        boolean validSymbols = true;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!(symbol == ' ' || symbol == '-' || symbol == 1025 || (symbol >= 1040 && symbol <= 1103) || symbol == 1105)) {
                validSymbols = false;
                break;
            }
        }
        return validSymbols;
    }

    private static int calculateNumberOfSpaces(String text) {
        int numberOfSpaces = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == ' ') {
                numberOfSpaces++;
            }
        }
        return numberOfSpaces;
    }
}