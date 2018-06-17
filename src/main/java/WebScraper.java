import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebScraper {

    ItemMapper itemMapper;

    public WebScraper(){
        itemMapper = new ItemMapper();
    }

    /**
     * Returns an Item object that will be stored in the itemsList.
     * The doc object should be scraped subpage of a given website that contains one of three types of items.
     *
     * @param  doc  document object that will be used to map an item into an object
     * @return      Item object
     */
    public Item checkItem(Document doc){
        Item item = itemMapper.mapItem(doc);

        return item;
    }
}
