package practice.string;

public class SequentialWordsNumbers {

    public static String sequentialWordsNumbers(String text) {
        StringBuilder sb = new StringBuilder();
        String substr;
        int count = 1;

        while (text.indexOf(' ') > 0) {
            substr = text.substring(0, text.indexOf(' '));
            sb.append("(").append(count).append(") ").append(substr).append(" ");
            text = text.substring(substr.length() + 1);
            count++;
        }

        if (!text.isBlank()) {
            substr = text;
            sb.append("(").append(count).append(") ").append(substr).append(" ");
        }

        return sb.toString().trim();
    }
}
