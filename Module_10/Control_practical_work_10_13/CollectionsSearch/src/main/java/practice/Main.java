package practice;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> numberList = CoolNumbers.generateCoolNumbers();

        String randomNumber = numberList.get((int) (Math.random() * numberList.size() - 1));

        long startBruteForceSearch;
        long endBruteForceSearch;
        boolean successfulBruteForceSearch;

        startBruteForceSearch = System.nanoTime();
        successfulBruteForceSearch = CoolNumbers.bruteForceSearchInList(numberList, randomNumber);
        endBruteForceSearch = System.nanoTime();

        long startBinarySearch;
        long endBinarySearch;
        boolean successfulBinarySearch;

        startBinarySearch = System.nanoTime();
        successfulBinarySearch = CoolNumbers.bruteForceSearchInList(numberList, randomNumber);
        endBinarySearch = System.nanoTime();

        long startSearchInHashSet;
        long endSearchInHashSet;
        boolean successfulSearchInHashSet;

        startSearchInHashSet = System.nanoTime();
        successfulSearchInHashSet = CoolNumbers.bruteForceSearchInList(numberList, randomNumber);
        endSearchInHashSet = System.nanoTime();

        long startSearchInTreeSet;
        long endSearchInTreeSet;
        boolean successfulSearchInTreeSet;

        startSearchInTreeSet = System.nanoTime();
        successfulSearchInTreeSet = CoolNumbers.bruteForceSearchInList(numberList, randomNumber);
        endSearchInTreeSet = System.nanoTime();

        System.out.println("Поиск перебором: номер "
                .concat(successfulBruteForceSearch ? "найден" : "не найден")
                .concat(", поиск занял ")
                .concat(String.valueOf(endBruteForceSearch - startBruteForceSearch))
                .concat("нс"));

        System.out.println("Бинарный поиск: номер "
                .concat(successfulBinarySearch ? "найден" : "не найден")
                .concat(", поиск занял ")
                .concat(String.valueOf(endBinarySearch - startBinarySearch))
                .concat("нс"));

        System.out.println("Поиск в HashSet: номер "
                .concat(successfulSearchInHashSet ? "найден" : "не найден")
                .concat(", поиск занял ")
                .concat(String.valueOf(endSearchInHashSet - startSearchInHashSet))
                .concat("нс"));

        System.out.println("Поиск в TreeSet: номер "
                .concat(successfulSearchInTreeSet ? "найден" : "не найден")
                .concat(", поиск занял ")
                .concat(String.valueOf(endSearchInTreeSet - startSearchInTreeSet))
                .concat("нс"));
    }
}
