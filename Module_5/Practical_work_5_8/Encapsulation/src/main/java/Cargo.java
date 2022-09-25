public class Cargo {
    private final Dimensions dimensions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean isPossibleToFlip;
    private final String registrationNumber;
    private final boolean isFragile;

    public Cargo(Dimensions dimensions, double weight, String deliveryAddress, boolean isPossibleToFlip,
                 String registrationNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.isPossibleToFlip = isPossibleToFlip;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Cargo setDimensions(Dimensions dimensions) {
        return new Cargo(dimensions, weight, deliveryAddress, isPossibleToFlip, registrationNumber, isFragile);
    }

    public double getWeight() {
        return weight;
    }

    public Cargo setWeight(double weight) {
        return new Cargo(dimensions, weight, deliveryAddress, isPossibleToFlip, registrationNumber, isFragile);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, isPossibleToFlip, registrationNumber, isFragile);
    }

    public boolean getPossibleToFlip() {
        return isPossibleToFlip;
    }

    public Cargo setPossibleToFlip(boolean isPossibleToFlip) {
        return new Cargo(dimensions, weight, deliveryAddress, isPossibleToFlip, registrationNumber, isFragile);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Cargo setRegistrationNumber(String registrationNumber) {
        return new Cargo(dimensions, weight, deliveryAddress, isPossibleToFlip, registrationNumber, isFragile);
    }

    public boolean getFragile() {
        return isFragile;
    }

    public Cargo setFragile(boolean isFragile) {
        return new Cargo(dimensions, weight, deliveryAddress, isPossibleToFlip, registrationNumber, isFragile);
    }

    @Override
    public String toString() {
        return "Cargo characteristics:" + System.lineSeparator()
                + "Width: " + dimensions.getWidth() + ";" + System.lineSeparator()
                + "Height: " + dimensions.getHeight() + ";" + System.lineSeparator()
                + "Length: " + dimensions.getLength() + ";" + System.lineSeparator()
                + "Weight: " + getWeight() + ";" + System.lineSeparator()
                + "Delivery address: " + getDeliveryAddress() + ";" + System.lineSeparator()
                + "Is possible to flip: " + getPossibleToFlip() + ";" + System.lineSeparator()
                + "Registration number: " + getRegistrationNumber() + ";" + System.lineSeparator()
                + "Is fragile: " + getFragile();
    }
}
