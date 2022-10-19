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
        StringBuilder result = new StringBuilder("Грузовик: " + trucks + System.lineSeparator()
                + "\tКонтейнер: " + containers + System.lineSeparator());

        Scanner scanner = new Scanner(System.in);

        int boxes = scanner.nextInt();

        if (boxes > 0) {
            for (int i = 1; i <= boxes; i++) {
                result.append(box).append(i).append(System.lineSeparator());
                if (i % MAX_NUMBER_OF_BOXES_IN_TRUCK == 0 && boxes > MAX_NUMBER_OF_BOXES_IN_TRUCK) {
                    trucks++;
                    result.append("Грузовик: ").append(trucks).append(System.lineSeparator());
                }
                if (i % MAX_NUMBER_OF_BOXES_IN_CONTAINER == 0 && boxes > MAX_NUMBER_OF_BOXES_IN_CONTAINER) {
                    containers++;
                    result.append("\tКонтейнер: ").append(containers).append(System.lineSeparator());
                }
            }
            System.out.print(result);
            System.out.println("Необходимо:"
                    + System.lineSeparator()
                    + "грузовиков - " + trucks + " шт." + System.lineSeparator()
                    + "контейнеров - " + containers + " шт.");
        } else {
            System.out.println("Необходимо:"
                    + System.lineSeparator()
                    + "грузовиков - " + 0 + " шт." + System.lineSeparator()
                    + "контейнеров - " + 0 + " шт.");
        }
    }
}