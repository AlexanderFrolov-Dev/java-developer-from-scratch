public class RAM {
    private final RAMType ramType;
    private final int volume;
    private final double weight;

    public RAM(RAMType ramType, int volume, double weight) {
        this.ramType = ramType;
        this.volume = volume;
        this.weight = weight;
    }

    public RAMType getRamType() {
        return ramType;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "RAM type - " + ramType + System.lineSeparator()
                + "RAM volume - " + volume + System.lineSeparator()
                + "RAM weight - " + weight;
    }
}
