import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static long result;
    public static void main(String[] args) {
        while(true) {
            System.out.println("Введите путь к папке или файлу");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            // C:\Users\Andrey Pakhomenkov\Desktop\Различные каталоги
            // 2633745390
            // 2,45 ГБ (2_633_745_390 байт)
            System.out.println(getFolderSize(file));
        }
    }

    public static long getFolderSize(File file) {

        if (file.isFile()) {

            result += file.length();
        } else {
            List<File> files = Arrays.asList(Objects.requireNonNull(file.listFiles()));
            files.forEach(Main::getFolderSize);
        }

        return result;
    }
}
