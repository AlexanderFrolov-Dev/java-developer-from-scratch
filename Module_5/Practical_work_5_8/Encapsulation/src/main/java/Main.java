import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Elevator elevator = new Elevator(-3, 26);
//        while (true) {
//            System.out.print("Введите номер этажа: ");
//            int floor = new Scanner(System.in).nextInt();
//            elevator.move(floor);
//        }

        Dimensions dimensions = new Dimensions(10, 5, 20);
        Cargo cargo = new Cargo(dimensions, 15, "Москва ул.Пушкина, д.1", true,
                "039BGR", false);
        Cargo otherCargoDimensions = cargo.setDimensions(new Dimensions(10, 10, 10));
        Cargo otherCargoWeight = cargo.setWeight(2.5);
        Cargo otherCargoDeliveryAddress = cargo.setDeliveryAddress("Москва ул.Пушкина, д.2");
        Cargo otherCargoPossibleToFlip = cargo.setPossibleToFlip(false);
        Cargo otherCargoRegistrationNumber = cargo.setRegistrationNumber("390BGR");
        Cargo otherCargoFragile = cargo.setFragile(true);

        System.out.println(cargo);
        System.out.println();
        System.out.println(otherCargoDimensions);
        System.out.println();
        System.out.println(otherCargoWeight);
        System.out.println();
        System.out.println(otherCargoDeliveryAddress);
        System.out.println();
        System.out.println(otherCargoPossibleToFlip);
        System.out.println();
        System.out.println(otherCargoRegistrationNumber);
        System.out.println();
        System.out.println(otherCargoFragile);
    }
}
