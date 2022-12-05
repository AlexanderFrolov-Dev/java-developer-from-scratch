import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println("Общая сумма: " + calculateSalarySum(text));
    }

    public static int calculateSalarySum(String text) {
        Matcher matcher = Pattern.compile("\\s+\\d+\\s+").matcher(text);
        int sum = 0;

        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group().trim());
        }

        return sum;
    }

}