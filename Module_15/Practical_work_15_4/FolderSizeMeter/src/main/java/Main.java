import java.io.File;
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

    public static long getFolderSize(File folder) {

        if (folder.isFile()) {
            return folder.length();
        }

        File[] files = folder.listFiles();
        long length = 0;

        for (File file : files) {
            length += getFolderSize(file);
        }

        return length;
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
