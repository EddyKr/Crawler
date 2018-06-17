public class Book extends Item {

    public String authors;
    public String publisher;
    public String isbn;

    public Book(String title, String category, String genre, String format, Integer year, String authors, String publisher, String isbn) {
        super(title, category, genre, format, year);

        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
