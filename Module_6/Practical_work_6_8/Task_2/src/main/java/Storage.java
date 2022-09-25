public class Storage {
    private final StorageType storageType;
    private final int volume;
    private final double weight;

    public Storage(StorageType storageType, int volume, double weight) {
        this.storageType = storageType;
        this.volume = volume;
        this.weight = weight;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public int getVolume() {
        return volume;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Storage type - " + storageType + System.lineSeparator()
                + "Storage volume - " + volume + System.lineSeparator()
                + "Storage weight - " + weight;
    }
}
