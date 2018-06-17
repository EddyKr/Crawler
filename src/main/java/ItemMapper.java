import org.jsoup.nodes.Document;

public class ItemMapper {

    /**
     * Entry point for mapping an item into one of three types.
     *
     * @param  doc  document object with Item information
     */
    public Item mapItem(Document doc){
        return null;
    }

    /**
     * Method to create a book object
     *
     * @param  doc  document object with Item information
     */
    public Book createBookObject(Document doc){
        return null;
    }

    /**
     * Method to create a movie object
     *
     * @param  doc  document object with Item information
     */
    public Movie createMovieObject(Document doc){
        return null;
    }

    /**
     * Method to create a music object
     *
     * @param  doc  document object with Item information
     */
    public Music createMusicObject(Document doc){
        return null;
    }
}
