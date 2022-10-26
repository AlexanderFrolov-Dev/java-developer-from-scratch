public class Main {

    public static void main(String[] args) {
        //Код взят из практической работы 9.5.
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(getSubstrings(text));
    }

    public static int getSubstrings(String text) {
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.indexOf(' ') > 0) {
                String currentSubstring = text.substring(0, text.indexOf(' '));
                text = text.substring(currentSubstring.length() + 1);
                if (isNumber(currentSubstring)) {
                    sum += Integer.parseInt(currentSubstring);
                }
            }
        }

        return sum;
    }

    public static boolean isNumber(String substring) {
        boolean isNumber = true;

        for (int i = 0; i < substring.length(); i++) {
            if (!Character.isDigit(substring.charAt(i))) {
                isNumber = false;
            }
        }

        return isNumber;
    }
}