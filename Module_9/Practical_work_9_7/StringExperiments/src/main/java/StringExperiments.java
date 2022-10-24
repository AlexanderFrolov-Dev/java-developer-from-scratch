import java.util.Scanner;

public class StringExperiments {
    public static void main(String[] args) {
        System.out.println("Введите Ф.И.О:");
        String fio = new Scanner(System.in).nextLine();

        String[] splitFio = fio.split("\\s+");

        if (splitFio.length > 3) {
            System.out.println("Введены лишние слова.");
        } else {
            for (String s : splitFio) {
                System.out.println(s);
            }
        }
    }
}
