public class Keyboard {
    private final KeyboardType keyboardType;
    private final boolean presenceOfBacklight;
    private final double weight;

    public Keyboard(KeyboardType keyboardType, boolean presenceOfBacklight, double weight) {
        this.keyboardType = keyboardType;
        this.presenceOfBacklight = presenceOfBacklight;
        this.weight = weight;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public boolean isPresenceOfBacklight() {
        return presenceOfBacklight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Keyboard type - " + keyboardType + System.lineSeparator()
                + "Presence of backlight - " + (presenceOfBacklight ? "yes" : "no") + System.lineSeparator()
                + "Keyboard weight - " + weight;
    }
}
