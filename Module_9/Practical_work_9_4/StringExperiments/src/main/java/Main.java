import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите текст:");
            String text = new Scanner(System.in).nextLine();
            System.out.println("Введите имя исходной кодировки:");
            String srcEncoding = new Scanner(System.in).nextLine();
            System.out.println("Введите имя целевой кодировки:");
            String dstEncoding = new Scanner(System.in).nextLine();

            String encoded;
            try {
                encoded = new String(text.getBytes(srcEncoding), dstEncoding);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Результат: " + encoded);
        }
    }
}
