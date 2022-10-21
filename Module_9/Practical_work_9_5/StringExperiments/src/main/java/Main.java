public class Main {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int firstDigit;
        int lastDigit;

        // TODO: 21.10.2022 Поделить пробелами строку на блоки. Потом проверять состоит ли подстрока только из цифр.

        for (int i = 0; i < text.length(); i++) {
            char symbol = (char) i;

            if (Character.isDigit(symbol)) {
                firstDigit = text.charAt(i);
            }
        }
    }
}
