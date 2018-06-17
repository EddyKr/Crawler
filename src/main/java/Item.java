import netscape.javascript.JSObject;

public class Item {
    public String title;
    public String category;
    public String genre;
    public String format;
    public Integer year;

    /**
     * Constructor of an Item used to store most important information.
     */
    public Item(String title, String category, String genre, String format, Integer year){
        this.title = title;
        this.category = category;
        this.genre = genre;
        this.format = format;
        this.year = year;
    }

    /**
     * Method that will map an item and return it as a JSON object.
     */
    public JSObject returnAsJSON(){
        return null;
    }
}
