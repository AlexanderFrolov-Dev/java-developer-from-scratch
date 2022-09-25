public class Main {
    public static void main(String[] args) {
//        ChildBankAccount account = new ChildBankAccount(10000);
//
//        account.depositMoney(1000);
//        account.depositMoney(2000);
//        account.depositMoney(10000);
//        account.depositMoney(-1000);
//        System.out.println("Balance: " + account.getBalance());
//
//        account.debitMoney(500);
//        account.debitMoney(422.75);
//        account.debitMoney(50000);
//        account.debitMoney(-50);
//        System.out.println("Balance: " + account.getBalance());

        Country russia = new Country("Russian Federation");

        russia.setArea(17_151_442);
        russia.setCapital("Moscow");
        russia.setPopulationSize(145_000_000);
        russia.setAccessToSea(true);

        System.out.println("Country name: " + russia.getName());
        System.out.println("Country area: " + russia.getArea() + "km");
        System.out.println("Capital of the country: " + russia.getCapital());
        System.out.println("Population size: " + russia.getPopulationSize());
        System.out.println("Has access to the sea: " + russia.getAccessToSea());

//        Smartphone smartPhone = new Smartphone("Android", 6.7, true);
//
//        smartPhone.setBrand("Samsung");
//        smartPhone.setModel("Galaxy A71");
//        smartPhone.setNumberOfCores(8);
//        smartPhone.setRAM(6);
//
//        System.out.println("Brand: " + smartPhone.getBrand());
//        System.out.println("Model: " + smartPhone.getModel());
//        System.out.println("OS: " + smartPhone.getOS());
//        System.out.println("Display size: " + smartPhone.getDisplaySize() + " in");
//        System.out.println("Number of cores: " + smartPhone.getNumberOfCores());
//        System.out.println("RAM: " + smartPhone.getRAM() + " Gb");
//        System.out.println("Has NFC: " + smartPhone.isHasNFC());
    }
}
