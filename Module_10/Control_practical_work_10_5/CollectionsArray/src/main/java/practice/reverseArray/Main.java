package practice.reverseArray;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        Stream.of(ReverseArray.reverse(line.split(" "))).forEach(System.out::println);
    }
}
