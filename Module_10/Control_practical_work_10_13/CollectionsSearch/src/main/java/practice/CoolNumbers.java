package practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CoolNumbers {
    public static final char[] LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static String number;
    private static String region;
    private static int minRegionNum = 1;
    private static int maxRegionNum = 199;

    public static List<String> generateCoolNumbers() {
        for (int i = 0; i < 3_000_000; i++) {

            number = generateLetter();

            if (region.length() == 1) {
                region = "0".concat(region);
            }
        }
        return Collections.emptyList();
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return false;
    }

    private static String generateLetter() {
        return String.valueOf(LETTERS[(int) (Math.random() * LETTERS.length + 1)]);
    }

    private static String generateRegion() {
        return String.valueOf((int) (Math.random() * ++maxRegionNum) + minRegionNum);
    }

    private static int generateNumber() {
        return (int) (Math.random() * 1000) + 1;
    }

}
