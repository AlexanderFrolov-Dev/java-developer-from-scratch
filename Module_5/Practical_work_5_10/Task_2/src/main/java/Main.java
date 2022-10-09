public class Main {
    public static void main(String[] args) {
        Smartphone smartPhone = new Smartphone("Android", 6.7, true);

        smartPhone.setBrand("Samsung");
        smartPhone.setModel("Galaxy A71");
        smartPhone.setNumberOfCores(8);
        smartPhone.setRam(6);

        System.out.println("Brand: " + smartPhone.getBrand());
        System.out.println("Model: " + smartPhone.getModel());
        System.out.println("OS: " + smartPhone.getOs());
        System.out.println("Display size: " + smartPhone.getDisplaySize() + " in");
        System.out.println("Number of cores: " + smartPhone.getNumberOfCores());
        System.out.println("RAM: " + smartPhone.getRam() + " Gb");
        System.out.println("Has NFC: " + smartPhone.isHasNfc());
    }
}
