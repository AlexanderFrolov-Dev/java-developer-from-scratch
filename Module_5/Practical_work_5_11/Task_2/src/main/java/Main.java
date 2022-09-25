public class Main {
    public static void main(String[] args) {
        Product product = new Product("Notebook", "0123456789");

        product.setPrice(30);
        System.out.println("Price: " + product.getPrice());
    }
}
