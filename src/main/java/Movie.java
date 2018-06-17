public class Movie extends Item {

    public String directors;
    public String writers;
    public String stars;

    public Movie(String title, String category, String genre, String format, Integer year, String directors, String writers, String stars) {
        super(title, category, genre, format, year);
        this.directors = directors;
        this.writers = writers;
        this.stars = stars;
    }
}