import java.util.List;
import java.util.Queue;

public class WebCrawler {

    private Queue<String> itemsQueue;
    private List<String> linksList;

    public WebCrawler(){
    }

    public Queue<String> getItemsQueue () {
        return itemsQueue;
    }

    public List<String> getLinksList () {
        return linksList;
    }

    public void crawl(String rootURL){

    }

    public void readUrl(String url, String findTag, String attribute){
    }
}
