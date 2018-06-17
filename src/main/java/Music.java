public class Music extends Item {

    public String artist;

    public Music(String title, String category, String genre, String format, Integer year, String artist) {
        super(title, category, genre, format, year);

        this.artist = artist;
    }
}