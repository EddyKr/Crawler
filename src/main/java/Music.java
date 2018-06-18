public class Music extends Item {
    //Variables
    public String artist;
    //Music constructor, Item as base
    public Music(String title, String category, String genre, String format, Integer year, String artist) {
        super(title, category, genre, format, year);

        this.artist = artist;
    }
}