public class Book extends Item {

    // Variables
    public String authors;
    public String publisher;
    public String isbn;

    //Book constructer Item as base
    public Book(String title, String category, String genre, String format, Integer year, String authors, String publisher, String isbn) {
        super(title, category, genre, format, year);

        this.authors = authors;
        this.publisher = publisher;
        this.isbn = isbn;
    }
}
