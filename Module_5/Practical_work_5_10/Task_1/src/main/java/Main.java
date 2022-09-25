import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Country russia = new Country("Russian Federation");

        russia.setArea(BigDecimal.valueOf(17_098_246));
        russia.setCapital("Moscow");
        russia.setPopulationSize(145_975_300);
        russia.setAccessToSea(true);

        System.out.println("Country name: " + russia.getName());
        System.out.println("Country area: " + russia.getArea() + " km");
        System.out.println("Capital of the country: " + russia.getCapital());
        System.out.println("Population size: " + russia.getPopulationSize());
        System.out.println("Has access to the sea: " + russia.getAccessToSea());
    }
}
