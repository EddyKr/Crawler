
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class WebCrawler {

    private WebScraper webScraper;
    private Queue<String> itemsQueue;
    private List<String> linksList;
    private List<Item> itemsList;
    private String rootURL;
    private String searchPhrase;

    /**
     * Constructor of a WebCrawler used to initialize lists and other objects needed to perform the scan.
     */
    public WebCrawler(){
        this.webScraper = new WebScraper();
        this.itemsQueue = new LinkedList<>();
        this.linksList = new ArrayList<>();
        this.itemsList = new ArrayList<>();
        this.rootURL = null;
        this.searchPhrase = null;
    }

    public Queue<String> getItemsQueue () {
        return itemsQueue;
    }
    public List<String> getLinksList () { return linksList; }

    /**
     * Entry point for crawling.
     *
     * @param  rootURL  an absolute URL the the page that will be scanned
     */
    public void startCrawling(String rootURL){
        this.rootURL = rootURL;
        chooseAction();
    }

    /**
     * Method that allows the user to choose his next action.
     */
    public void chooseAction(){
        System.out.println("Choose your next action:");
        System.out.println("Press 1 to scrape all items from the website.");
        System.out.println("Press 2 to look for specific item on the website.");

        Scanner sc = new Scanner(System.in);
        String action = sc.nextLine();

        switch(action){
            case "1":
                crawl("all");
                break;
            case "2":
                System.out.println("Input a search phrase.");
                searchPhrase = sc.nextLine();
                crawl("specific");
                break;
        }
    }

    /**
     * Entry point for WebCrawling the whole website.
     *
     * @param  action  action to be performed for scan
     */
    public void crawl(String action){
        this.itemsQueue.add(rootURL);
        this.linksList.add(rootURL);

        while(!itemsQueue.isEmpty()){
            String v = this.itemsQueue.remove();
            //Crawl only target website - TODO change v.contains("tci") to accept more URLs
            if(v.contains("tci")){
                if (action.equals("all")) {
                    searchPhrase = null;
                    readUrl(v, "a", "abs:href");
                } else if (!searchPhrase.isEmpty()){
                    if(!readUrl(v, "a", "abs:href")){
                        break;
                    }
                }
            }
        }

        displayResult();

        chooseAction();
    }

    public void displayResult(){
        if (!searchPhrase.isEmpty()){
            System.out.println(itemsList.get(itemsList.size() - 1).title);
        }
    }

    /**
     * Entry point for WebCrawling the given URL.
     * It will scan and add the links into the linksList.
     *
     * @param  url  an URL of the page that is suppose to get scanned
     * @param  findTag a search phrase that will be used to look for specific item
     * @param  attribute extra attribute that will be used with search
     * @return if item has been found then return false in order to stop crawling
     */
    public boolean readUrl(String url, String findTag, String attribute){
        try {
            Document doc = Jsoup.connect(url).validateTLSCertificates(false).get();
            Elements links = doc.select(findTag);
            for (Element e : links) {

                String link = e.attr(attribute);
                if(!linksList.contains(link)){
                    linksList.add(link);
                    System.out.println("Link found: " + link);
                    itemsQueue.add(link);
                }
            }

            Item newItem = webScraper.checkItem(doc);

            if (newItem != null) {
                itemsList.add(newItem);
            }


            if (!searchPhrase.isEmpty()) {
                if (newItem.title.equals(searchPhrase)){

                    System.out.println("TITLE");
                    System.out.println(newItem.title);

                    return false;
                }
            }

            System.out.println("Size of items list: ");
            System.out.println(itemsList.size());

        } catch (Exception o) {System.out.println(o.getMessage());}

        return true;
    }
}
