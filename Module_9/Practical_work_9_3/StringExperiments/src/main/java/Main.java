import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите первое число:");
            Scanner scanner = new Scanner(System.in);
            String inputLine = scanner.nextLine();
            String firstNumber;

            while (!isDigit(inputLine)) {
                System.out.println("Введенная строка не является числом. Введите первое число:");
                inputLine = scanner.nextLine();
            }

            firstNumber = inputLine;

            System.out.println("Введите символ арифметического действия:");
            inputLine = scanner.nextLine();
            String arithmeticActionCharacter;

            while (!isArithmeticActionCharacter(inputLine)) {
                System.out.println("Введенная строка не символом арифметического действия."
                        .concat(" Введите символом арифметического действия"));
                inputLine = scanner.nextLine();
            }

            arithmeticActionCharacter = inputLine;

            System.out.println("Введите второе число:");
            inputLine = scanner.nextLine();
            String secondNumber;

            while (!isDigit(inputLine)) {
                System.out.println("Введенная строка не является числом. Введите второе число:");
                inputLine = scanner.nextLine();
            }

            secondNumber = inputLine;

            String finalLine = "";
            int result;
            switch (arithmeticActionCharacter.trim()) {
                case "+" -> {
                    result = Integer.parseInt(firstNumber.trim()) + Integer.parseInt(secondNumber.trim());
                    finalLine = firstNumber.trim()
                            .concat(" + ")
                            .concat(secondNumber.trim())
                            .concat(" = ")
                            .concat(String.valueOf(result));
                }
                case "-" -> {
                    result = Integer.parseInt(firstNumber.trim()) - Integer.parseInt(secondNumber.trim());
                    finalLine = firstNumber.trim()
                            .concat(" - ")
                            .concat(secondNumber.trim())
                            .concat(" = ")
                            .concat(String.valueOf(result));
                }
                case "*" -> {
                    result = Integer.parseInt(firstNumber.trim()) * Integer.parseInt(secondNumber.trim());
                    finalLine = firstNumber.trim()
                            .concat(" * ")
                            .concat(secondNumber.trim())
                            .concat(" = ")
                            .concat(String.valueOf(result));
                }
                case "/" -> {
                    result = Integer.parseInt(firstNumber.trim()) / Integer.parseInt(secondNumber.trim());
                    finalLine = firstNumber.trim()
                            .concat(" / ")
                            .concat(secondNumber.trim())
                            .concat(" = ")
                            .concat(String.valueOf(result));
                }
            }
            System.out.println(finalLine);
        }
    }

    private static boolean isDigit(String str) {
        return str.trim().matches("[0-9]+");
    }

    private static boolean isArithmeticActionCharacter(String str) {
        return str.trim().equals("+")
                || str.trim().equals("-")
                || str.trim().equals("*")
                || str.trim().equals("/");
    }
}