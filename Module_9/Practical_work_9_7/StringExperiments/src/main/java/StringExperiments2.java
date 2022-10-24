import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExperiments2 {
    public static void main(String[] args) {
        System.out.println("Введите числа через пробел:");
        String text = new Scanner(System.in).nextLine();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(text);
        int sum = 0;

        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }

        System.out.println("Сумма чисел в тесте: " + sum);
    }
}
