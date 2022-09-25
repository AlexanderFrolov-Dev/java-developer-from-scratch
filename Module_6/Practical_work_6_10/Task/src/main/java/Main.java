public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator ac = new ArithmeticCalculator(10, 5);

        System.out.println("ADD: " + ac.calculate(Operation.ADD));
        System.out.println("SUBTRACT: " + ac.calculate(Operation.SUBTRACT));
        System.out.println("MULTIPLY: " + ac.calculate(Operation.MULTIPLY));
    }
}
