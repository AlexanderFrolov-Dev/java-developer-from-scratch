public class Book {
    private final String title;
    private final String author;
    private final int numberOfPages;
    private final String isbn;

    public Book(String title, String author, int numberOfPages, String numberISBN) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.isbn = numberISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }
}
