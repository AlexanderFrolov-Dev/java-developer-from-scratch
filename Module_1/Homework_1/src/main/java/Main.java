public class Main {
    public static void main(String[] args) {
        System.out.println("Информация о системе");
        System.out.println("Операционная система: ");
        System.out.println(System.getProperty("os.name") + " " + System.getProperty("os.version"));
        System.out.println("Количество ядер процессора: ");
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("Количество памяти доступной JVM: ");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024 + "Mb");
    }
}
