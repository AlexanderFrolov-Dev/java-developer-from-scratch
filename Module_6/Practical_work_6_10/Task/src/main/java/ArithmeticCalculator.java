public class ArithmeticCalculator {
    private final double a;
    private final double b;

    public ArithmeticCalculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double calculate(Operation operation) {
        return switch (operation) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
        };
    }
}
