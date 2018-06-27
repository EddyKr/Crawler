
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class WebCrawler {

    //Variables
    private WebScraper webScraper;
    private Queue<String> itemsQueue;
    public List<String> linksList;
    public List<Item> itemsList;
    public String rootURL;
    public String searchPhrase;
    private long elapsedTime;
    public boolean itemFound;

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
        this.elapsedTime = 0;
        this.itemFound = false;
    }

    // Getters
    public Queue<String> getItemsQueue () {
        return itemsQueue;
    }

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

            default:
                throw new IllegalArgumentException("This option does not exist");
        }
    }

    /**
     * Entry point for WebCrawling the whole website.
     *
     * @param  action  action to be performed for scan
     */
    public void crawl(String action){
        if(!action.equals("all") && !action.equals("specific")){
            throw new IllegalArgumentException("Illegal action: " + action);
        }
        this.itemsQueue.add(rootURL);
        this.linksList.add(rootURL);

        long start = System.nanoTime();

        while(!itemsQueue.isEmpty()){
            String v = this.itemsQueue.remove();
            if(v.contains(rootURL)){
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

        elapsedTime = System.nanoTime() - start;

        displayResult();
    }

    /**
     * Entry point for WebCrawling the given URL.
     */
    public void displayResult(){
        System.out.println("");
        System.out.println("Time elapsed: " + elapsedTime);

        if (searchPhrase != null){
            if (itemFound) {
                System.out.println(itemsList.get(itemsList.size() - 1).returnAsJSON());
            } else {
                System.out.println("Item not found!");
            }
        } else {
            for (int i = 0; i < itemsList.size(); i++){
                System.out.println(itemsList.get(i).returnAsJSON());
            }
        }

        resetVariables();

        System.out.println("");
    }

    /**
     * Method used to reset all needed variables after run.
     */
    public void resetVariables(){
        this.itemsQueue.clear();
        this.linksList.clear();
        this.itemsList.clear();
        this.searchPhrase = null;
        this.elapsedTime = 0;
        this.itemFound = false;
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
                    itemsQueue.add(link);
                }
            }

            Item newItem = webScraper.checkItem(doc);

            if (newItem != null) {
                itemsList.add(newItem);
            }


            if (!searchPhrase.isEmpty()) {
                if (newItem.title.equals(searchPhrase)){
                    itemFound = true;
                    return false;
                }
            }

        } catch (Exception o) {
            if(o.getMessage() != null) {
                System.out.println(o.getMessage());
            }
        }

        return true;
    }
}
