
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WebCrawler {

    private Queue<String> itemsQueue;
    private List<String> linksList;

    /**
     * Constructor of a WebCrawler used to initialize lists and other objects needed to perform the scan.
     */
    public WebCrawler(){
        this.itemsQueue = new LinkedList<>();
        this.linksList = new ArrayList<>();
    }

    public Queue<String> getItemsQueue () {
        return itemsQueue;
    }
    public List<String> getLinksList () { return linksList; }

    /**
     * Entry point for WebCrawling the given URL.
     *
     * @param  rootURL  an absolute URL the the page that will be scanned
     */

    public void crawl(String rootURL){
        this.itemsQueue.add(rootURL);
        this.linksList.add(rootURL);

        while(!itemsQueue.isEmpty()){

            String v = this.itemsQueue.remove();
            //Crawl only target website - TODO change v.contains("tci") to accept more URLs
            if(v.contains("tci")){
                readUrl(v,"a", "abs:href");
            }
        }
    }

    /**
     * Entry point for WebCrawling the given URL.
     * It will scan and add the links into the linksList.
     *
     * @param  url  an URL of the page that is suppose to get scanned
     * @param  findTag a search phrase that will be used to look for specific item
     * @param attribute extra attribute that will be used with search
     */
    public void readUrl(String url, String findTag, String attribute){
        try {
            Document doc = Jsoup.connect(url).validateTLSCertificates(false).get();
            Elements links = doc.select(findTag);
            for (Element e : links) {

                String link = e.attr(attribute);
                if(!linksList.contains(link)){
                    linksList.add(link);
                    System.out.println("Found: "+link);
                    itemsQueue.add(link);
                }
            }

        } catch (Exception o) {System.out.println(o.getMessage());}
    }
}
