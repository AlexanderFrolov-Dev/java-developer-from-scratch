import java.math.BigDecimal;

public class Country {
    private String name;
    private int populationSize;
    private BigDecimal area;
    private String capital;
    private boolean isAccessToSea;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean getAccessToSea() {
        return isAccessToSea;
    }

    public void setAccessToSea(boolean accessToSea) {
        this.isAccessToSea = accessToSea;
    }
}


