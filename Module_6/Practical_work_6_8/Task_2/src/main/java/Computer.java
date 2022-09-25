public class Computer {
    private final String vendor;
    private final String name;
    private Processor processor;
    private RAM ram;
    private Storage storage;
    private Display display;
    private Keyboard keyboard;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public double getTotalWeight() {
        return processor.getWeight()
                + ram.getWeight()
                + storage.getWeight()
                + display.getWeight()
                + keyboard.getWeight();
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "Vendor: " + getVendor() + System.lineSeparator()
                + "Name: " + getName() + System.lineSeparator()
                + "Processor: " + System.lineSeparator() + getProcessor() + System.lineSeparator()
                + "RAM: " + System.lineSeparator() + getRam() + System.lineSeparator()
                + "Storage: " + System.lineSeparator() + getStorage() + System.lineSeparator()
                + "Display: " + System.lineSeparator() + getDisplay() + System.lineSeparator()
                + "Keyboard: " + System.lineSeparator() + getKeyboard();
    }
}
