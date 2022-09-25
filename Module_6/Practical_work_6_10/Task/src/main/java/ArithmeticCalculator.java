public class ArithmeticCalculator {
    private final double a;
    private final double b;
    private Operation operation;

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
        double result = 0;
        switch (operation) {
            case ADD:
                result = a + b;
                break;
            case SUBTRACT:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
        }
        return result;
    }
}
