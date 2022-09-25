public class Main {
    public static void main(String[] args) {

        Processor processor = new Processor(3770, 8, "Intel", 10.5);
        RAM ram = new RAM(RAMType.DDR4, 16, 30);
        Storage storage = new Storage(StorageType.SDD, 1000, 100);
        Display display = new Display(24, DisplayType.VA, 2150);
        Keyboard keyboard = new Keyboard(KeyboardType.MEMBRANE, true, 505.5);
        Computer computer = new Computer("ASUS", "MyPC");
        computer.setProcessor(processor);
        computer.setRam(ram);
        computer.setStorage(storage);
        computer.setDisplay(display);
        computer.setKeyboard(keyboard);

        System.out.println(computer);
    }
}
