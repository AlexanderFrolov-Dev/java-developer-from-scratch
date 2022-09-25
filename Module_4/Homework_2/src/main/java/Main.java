public class Main {

    public static void main(String[] args) {
        Basket basketDrinks = new Basket();
        basketDrinks.add("Milk", 40);
        basketDrinks.add("Coffee", 30);
        basketDrinks.add("Juice", 50, 3, 3);
        basketDrinks.add("Cola", 60, 5, 7.5);
        basketDrinks.add("Tea", 20, 2);
        basketDrinks.print("Basket drinks:");
        System.out.println("Total weight: " + basketDrinks.getTotalWeight());
        System.out.println("Total price: " + basketDrinks.getTotalPrice());
    }
}
