import java.util.Scanner;

// ForCycle
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число для нахождения его множителей:");

        int value = -1;

        while (value != 0) {
            value = new Scanner(System.in).nextInt();
            if (value > 0) {
                for (int i = 1; i <= value; i++) {
                    for (int j = 1; j <= value; j++) {
                        if (i * j == value) {
                            System.out.println(i + "*" + j);
                        }
                    }
                }
            } else if (value < 0) {
                System.out.println("Число должно быть положительным");
            }
        }
        System.out.println("Программа закончила свое выполнение");
    }
}
