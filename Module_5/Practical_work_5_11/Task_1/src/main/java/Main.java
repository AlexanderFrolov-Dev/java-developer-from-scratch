public class Main {
    public static void main(String[] args) {

        Book fightClub = new Book("Fight Club", "Chuck Palahniuk",
                256, "978-5-17-016682-4");

        System.out.println("Title: " + fightClub.getTitle());
        System.out.println("Author: " + fightClub.getAuthor());
        System.out.println("Number of pages: " + fightClub.getNumberOfPages());
        System.out.println("ISBN: " + fightClub.getIsbn());
    }
}
