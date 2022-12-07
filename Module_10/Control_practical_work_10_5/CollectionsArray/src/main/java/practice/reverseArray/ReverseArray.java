package practice.reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {

        for (int i = 0; i < strings.length / 2; i++) {
            String element = strings[i];
            strings[i] = strings[strings.length - i - 1];
            strings[strings.length - i - 1] = element;
        }
        return strings;
    }

}