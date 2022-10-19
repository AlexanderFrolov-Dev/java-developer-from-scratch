package practice;

import java.util.Scanner;

public class TrucksAndContainers {
    public static final int MAX_NUMBER_OF_CONTAINERS_IN_TRUCK = 12;
    public static final int MAX_NUMBER_OF_BOXES_IN_CONTAINER = 27;
    public static final int MAX_NUMBER_OF_BOXES_IN_TRUCK
            = MAX_NUMBER_OF_CONTAINERS_IN_TRUCK * MAX_NUMBER_OF_BOXES_IN_CONTAINER;

    public static void main(String[] args) {
        int trucks = 1;
        int containers = 1;
        String box = "\t\tЯщик: ";
        String result = "Грузовик: " + trucks + "\n" + "\tКонтейнер: " + containers + "\n";

//        System.out.println("Введите количество коробок: ");

        Scanner scanner = new Scanner(System.in);

        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */

        if (boxes > 0) {
            for (int i = 1; i <= boxes; i++) {
                result += box + i + "\n";
                if (i % MAX_NUMBER_OF_BOXES_IN_TRUCK == 0 && boxes > MAX_NUMBER_OF_BOXES_IN_TRUCK) {
                    trucks++;
                    result += "Грузовик: " + trucks + "\n";
                }
                if (i % MAX_NUMBER_OF_BOXES_IN_CONTAINER == 0 && boxes > MAX_NUMBER_OF_BOXES_IN_CONTAINER) {
                    containers++;
                    result += "\tКонтейнер: " + containers + "\n";
                }
            }
            System.out.print(result);
            System.out.println("Необходимо:\n"
                    + "грузовиков - " + trucks + " шт.\n"
                    + "контейнеров - " + containers + " шт.");
        } else {
            System.out.println("Необходимо:\n"
                    + "грузовиков - " + 0 + " шт.\n"
                    + "контейнеров - " + 0 + " шт.");
        }
    }
}
