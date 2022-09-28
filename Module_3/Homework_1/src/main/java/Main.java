// FactorialCalculator

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int value = -1;
        int multiplier = 1;
        final String EXCLAMATION_MARK = "!";
        String multiplyBy = "";

        System.out.println("Введите число для подсчета его факториала:");

        while (value != 0) {
            value = new Scanner(System.in).nextInt();

            if (value > 0) {
                for (int i = 1; i <= value; i++) {
                    multiplier *= i;
                    multiplyBy += multiplyBy.isEmpty() ? "" + i : " * " + i;
                }

                if (value != 0) {
                    System.out.println(value + EXCLAMATION_MARK + " = " + multiplyBy + " = " + multiplier);
                }

                multiplyBy = "";
                multiplier = 1;
            } else if (value < 0) {
                System.out.println("Число должно быть положительным");
            }
        }
        System.out.println("Программа закончила своё выполнение");
    }
}
