public class Main {
    public static void main(String[] args) {
        Arithmetic first = new Arithmetic(5, 7);
        Arithmetic second = new Arithmetic(3, 8);

        System.out.println(first.sum());
        System.out.println(first.multiply());
        System.out.println(first.getMax());
        System.out.println(first.getMin());

        System.out.println();

        System.out.println(second.sum());
        System.out.println(second.multiply());
        System.out.println(second.getMax());
        System.out.println(second.getMin());
    }
}
