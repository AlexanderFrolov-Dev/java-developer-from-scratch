import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            String[] words = input.split("\\s+");
            if (input.equals("0")) {
                break;
            }

            if (words.length == 3 && isValidWords(words)) {
                System.out.println("Фамилия: ".concat(words[0]).concat(System.lineSeparator())
                        .concat("Имя: ").concat(words[1]).concat(System.lineSeparator())
                        .concat("Отчество: ").concat(words[2]));
            } else {
                System.out.println("Введенная строка не является ФИО");
            }
        }
    }

    private static boolean isValidWords(String[] words) {
        Pattern pattern = Pattern.compile("[А-ЯЁа-яё+]-?[А-ЯЁа-яё+]?");
        boolean isValid = true;

        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            if (!matcher.find()) {
                isValid = false;
            }
        }

        return isValid;
    }

}