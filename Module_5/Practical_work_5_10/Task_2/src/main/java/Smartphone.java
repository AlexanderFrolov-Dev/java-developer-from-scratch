public class Smartphone {
    private String brand;
    private String model;
    private String os;
    private double displaySize;
    private int numberOfCores;
    private int ram;
    private boolean hasNfc;

    public Smartphone(String os, double displaySize, boolean hasNfc) {
        this.os = os;
        this.displaySize = displaySize;
        this.hasNfc = hasNfc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public boolean isHasNfc() {
        return hasNfc;
    }

    public void setHasNfc(boolean hasNfc) {
        this.hasNfc = hasNfc;
    }
}
