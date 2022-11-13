package practice;

import java.util.*;

public class CoolNumbers {
    public static final char[] LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static final int MIN_REGION_NUM = 1;
    private static final int MAX_REGION_NUM = 199;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 999;

    public static List<String> generateCoolNumbers() {
        List<String> numberList = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < 3_000_000; i++) {
            number.append(generateLetter())
                    .append(generateNumber())
                    .append(generateLetter())
                    .append(generateLetter())
                    .append(generateRegion());

            numberList.add(number.toString());
            number.delete(0, number.length());
        }

        Collections.sort(numberList);

        return numberList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        boolean find = false;

        for (String string : list) {
            if (string.equals(number)) {
                find = true;
                break;
            }
        }

        return find;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
//        boolean find = false;
//        int indexOfElementToCompare = sortedList.size();
//        int vector = 0;
//        int halfOfList = 0;
//
////        List<Integer> leftPartList = new ArrayList<>();
////        List<Integer> rightPartList = new ArrayList<>();
////
////        for (int i = 0; i <= indexOfElementToCompare; i++) {
////            if (indexOfElementToCompare % 2 == 0) {
////
////            }
////        }
//
//        for (int i = 0; i <= indexOfElementToCompare; i++) {
//            System.out.println("=====================================================================================");
//            System.out.println("indexOfElementToCompare: " + indexOfElementToCompare);
//            System.out.println("=====================================================================================");
//            if (indexOfElementToCompare % 2 == 0) {
//                vector = sortedList.get(indexOfElementToCompare / 2 + 1).compareTo(number);
//                System.out.println("=====================================================================================");
//                System.out.println("vector: " + vector);
//                System.out.println("=====================================================================================");
//                if (vector == 0) {
//                    find = true;
//                    break;
//                } else if (vector > 0) {
//                    halfOfList = indexOfElementToCompare / 2 + 1;
//                    indexOfElementToCompare = halfOfList + halfOfList / 2 - 1;
//                } else {
//                    indexOfElementToCompare = indexOfElementToCompare / 2 + 1;
//                }
//                System.out.println("=====================================================================================");
//                System.out.println("indexOfElementToCompare: " + indexOfElementToCompare);
//                System.out.println("=====================================================================================");
//            } else {
//                vector = sortedList.get(indexOfElementToCompare / 2 + 1).compareTo(number);
//                System.out.println("=====================================================================================");
//                System.out.println("vector: " + vector);
//                System.out.println("=====================================================================================");
//                if (vector == 0) {
//                    find = true;
//                    break;
//                } else if (vector > 0) {
//                    halfOfList = indexOfElementToCompare / 2 + 1;
//                    indexOfElementToCompare = halfOfList + halfOfList / 2;
//                } else {
//                    indexOfElementToCompare = indexOfElementToCompare / 2 + 1;
//                }
//                System.out.println("=====================================================================================");
//                System.out.println("indexOfElementToCompare: " + indexOfElementToCompare);
//                System.out.println("=====================================================================================");
//            }
//        }
//
////        while (!sortedList.get(indexOfElementToCompare).equals(number)) {
////            if (sortedList.size() % 2 == 0) {
////                indexOfElementToCompare = sortedList.size() / 2;
////                if ()
////            } else {
////                indexOfElementToCompare = (sortedList.size() / 2) + 1;
////            }
////        }

        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

    private static String generateLetter() {
        return String.valueOf(LETTERS[(int) (Math.random() * LETTERS.length)]);
    }

    private static String generateRegion() {
        String region = String
                .valueOf((int) (Math.random() * ((MAX_REGION_NUM - MIN_REGION_NUM) + 1)) + MIN_REGION_NUM);

        if (region.length() == 1) {
            region = "0".concat(region);
        }

        return region;
    }

    private static String generateNumber() {
        String number = String.valueOf((int) (Math.random() * ((MAX_NUMBER - MIN_NUMBER) + 1)) + MIN_NUMBER);

        if (number.length() == 1) {
            number = "00".concat(number);
        }

        if (number.length() == 2) {
            number = "0".concat(number);
        }

        return number;
    }

}
