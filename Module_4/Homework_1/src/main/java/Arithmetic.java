public class Arithmetic {
    private int a;
    private int b;

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int sum() {
        return a + b;
    }

    int multiply() {
        return a * b;
    }

    int getMax() {
        return a > b ? a : b;
    }

    int getMin() {
        return Math.min(a, b);
    }
}
