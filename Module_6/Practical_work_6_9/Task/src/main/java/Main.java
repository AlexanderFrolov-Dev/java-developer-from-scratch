public class Main {
    public static void main(String[] args) {
        Basket basketDrinks = new Basket();
        basketDrinks.add("Milk", 40);
        basketDrinks.add("Coffee", 30);
        basketDrinks.add("Juice", 50, 3, 3);
        basketDrinks.add("Cola", 60, 5, 7.5);
        basketDrinks.add("Tea", 20, 2);
        basketDrinks.print("Basket drinks:");
        System.out.println("Total price basket drinks: " + basketDrinks.getTotalPrice());
        System.out.println("Total weight basket drinks: " + basketDrinks.getTotalWeight());
        System.out.println();

        Basket basketFood = new Basket();
        basketFood.add("bread", 40);
        basketFood.add("butter", 30);
        basketFood.add("Eggs", 50, 12, 0.5);
        basketFood.add("Potatoes", 60, 10, 1.5);
        basketFood.add("Onion", 20, 2);
        basketFood.print("Basket food:");
        System.out.println("Total price basket food: " + basketFood.getTotalPrice());
        System.out.println("Total weight basket food: " + basketFood.getTotalWeight());
        System.out.println("Total price in all baskets: " + Basket.getTotalPriceInAllBaskets());
        System.out.println("Total count in all baskets: " + Basket.getTotalCountInAllBaskets());
        System.out.println("Average total price: " + Basket.getAverageTotalPriceAllBaskets());
        System.out.println("Average price of basket: " + Basket.getAveragePriceOfBasket());
    }
}
