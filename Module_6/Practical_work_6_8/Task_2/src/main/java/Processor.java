public class Processor {
    private final int frequency;
    private final int coresNumber;
    private final String vendor;
    private final double weight;

    public Processor(int frequency, int coresNumber, String vendor, double weight) {
        this.frequency = frequency;
        this.coresNumber = coresNumber;
        this.vendor = vendor;
        this.weight = weight;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCoresNumber() {
        return coresNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Frequency - " + frequency + System.lineSeparator()
                + "Cores number - " + coresNumber + System.lineSeparator()
                + "Vendor processor - " + vendor;
    }
}
