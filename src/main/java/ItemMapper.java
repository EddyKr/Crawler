import org.jsoup.nodes.Document;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ItemMapper {

    /**
     * Entry point for mapping an item into one of three types.
     *
     * @param  doc  document object with Item information
     */
    public Item mapItem(Document doc){

        String category = doc.getElementsByTag("tbody").first().getElementsByTag("td").first().html();

        Item item = null;

        switch(category){
            case "Books":
                item = createBookObject(doc);
                break;
            case "Movies":
                item = createMovieObject(doc);
                break;
            case "Music":
                item = createMusicObject(doc);
                break;
        }

        return item;
    }

    /**
     * Method to create a book object
     *
     * @param  doc  document object with Item information
     */
    public Book createBookObject(Document doc){

        //Map book into an object
        String title = doc.getElementsByTag("h1").first().html();

        Element table = doc.select("div.media-details").select("table").get(0);
        Elements rows = table.select("tr");

        String category = rows.get(0).select("td").html();
        String genre = rows.get(1).select("td").html();
        String format = rows.get(2).select("td").html();
        Integer year = Integer.parseInt(rows.get(3).select("td").html());
        String authors = rows.get(4).select("td").html();
        String publisher = rows.get(5).select("td").html();
        String isbn = rows.get(6).select("td").html();

        Book bookItem = new Book(title, category, genre, format, year, authors, publisher, isbn);

        System.out.println(table);

        return bookItem;
    }

    /**
     * Method to create a movie object
     *
     * @param  doc  document object with Item information
     */
    public Movie createMovieObject(Document doc){
        //Map movie into an object
        String title = doc.getElementsByTag("h1").first().html();

        Element table = doc.select("div.media-details").select("table").get(0);
        Elements rows = table.select("tr");

        String category = rows.get(0).select("td").html();
        String genre = rows.get(1).select("td").html();
        String format = rows.get(2).select("td").html();
        Integer year = Integer.parseInt(rows.get(3).select("td").html());
        String directors = rows.get(4).select("td").html();
        String writers = rows.get(5).select("td").html();
        String stars = rows.get(6).select("td").html();

        Movie movieItem = new Movie(title, category, genre, format, year, directors, writers, stars);

        System.out.println(table);

        return movieItem;
    }

    /**
     * Method to create a music object
     *
     * @param  doc  document object with Item information
     */
    public Music createMusicObject(Document doc){
        //Map music into an object
        String title = doc.getElementsByTag("h1").first().html();

        Element table = doc.select("div.media-details").select("table").get(0);
        Elements rows = table.select("tr");

        String category = rows.get(0).select("td").html();
        String genre = rows.get(1).select("td").html();
        String format = rows.get(2).select("td").html();
        Integer year = Integer.parseInt(rows.get(3).select("td").html());
        String artist = rows.get(4).select("td").html();

        Music musicItem = new Music(title, category, genre, format, year, artist);

        System.out.println(table);

        return musicItem;
    }
}
