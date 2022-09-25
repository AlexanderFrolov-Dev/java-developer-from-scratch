public class Main {
    public static void main(String[] args) {
//        Product TV = new Product("TV", 50_000);
//        Product notebook = new Product("Notebook", 75_000);
//        Product smartphone = new Product("Smartphone", 35_000);
//
//        System.out.println("Количество продуктов: " + Product.getCount());
//        System.out.println("Средняя цена продуктов: " + Product.getAverageTotalPrice());

//        ArithmeticCalculator ac = new ArithmeticCalculator(10, 6);
//
//        System.out.println("Add result: " + ac.calculate(Operation.ADD));
//        System.out.println("Subtract result: " + ac.calculate(Operation.SUBTRACT));
//        System.out.println("Multiply result: " + ac.calculate(Operation.MULTIPLY));

        Engine engine = new Engine(EngineType.GAS, 1.5, 102);
        Car car = new Car(engine, CarType.SEDAN, 1065 );

        System.out.println(car);
    }
}
