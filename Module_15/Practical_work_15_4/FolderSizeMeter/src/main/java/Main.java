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
            long size = getFolderSize(file);
            System.out.println(getHumanReadableSize(size));
            result = 0;
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

    public static String getHumanReadableSize(long size) {
        String[] units = {"b", "Kb", "Mb", "Gb"};
        String result = "";

        for (int i = 0; i < units.length; i++) {
            double resultNumber = Math.pow(1024, i);
            if (size / resultNumber > 1) {
                result = Math.round((size / resultNumber) * 100.0) / 100.0 + units[i];
            }
        }

        return result;
    }
}
