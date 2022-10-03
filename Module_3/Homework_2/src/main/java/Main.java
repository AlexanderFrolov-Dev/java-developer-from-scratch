import java.util.Scanner;

// ForCycle
public class Main {
    public static void main(String[] args) {
        int value = -1;

        do {
            System.out.println("Введите число для нахождения его множителей:");

            value = new Scanner(System.in).nextInt();
            if (value > 0) {
                for (int i = 1; i <= value; i++) {
                    if (value % i == 0) {
                        int j = value / i;
                        System.out.println(i + "*" + j);
                    }
                }
            } else if (value < 0) {
                System.out.println("Число должно быть положительным");
            }
        } while (value != 0);

        System.out.println("Программа закончила свое выполнение");
    }
}
