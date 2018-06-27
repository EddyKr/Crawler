import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WebCrawlerTest {

    @Before
    public void initialization(){
    }

    @Test
    public void afterCreationShouldHaveNoItems() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();

        //assert
        assertEquals(0, webCrawler.itemsList.size());
        assertEquals(0, webCrawler.getItemsQueue().size());
        assertEquals(0, webCrawler.linksList.size());
    }

    @Test
    public void shouldResetVariables() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();

        Item item = mock(Item.class);
        webCrawler.itemsList.add(item);

        webCrawler.linksList.add("some_link");

        //act
        webCrawler.resetVariables();

        //assert
        assertEquals(0, webCrawler.itemsList.size());
        assertEquals(0, webCrawler.linksList.size());
    }

    @Test
    public void shouldReadUrlWithoutSearchPhrase() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        String tag = "a";
        String attribute = "abs:href";
        String url = "http://localhost/tci/details.php?id=102";

        //act
        Boolean readResult =  webCrawler.readUrl(url,tag,attribute);
        int itemListResult = webCrawler.itemsList.size();
        //assert
        assertEquals(true, readResult);
        assertEquals(1, itemListResult);

    }

    @Test
    public void shouldReadUrlWithSearchPhrase() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.searchPhrase = "Clean Code: A Handbook of Agile Software Craftsmanship";
        String tag = "a";
        String attribute = "abs:href";
        String url = "http://localhost/tci/details.php?id=102";

        //act
        Boolean readResult =  webCrawler.readUrl(url,tag,attribute);
        Boolean itemFound = webCrawler.itemFound;
        //assert
        assertEquals(false, readResult);
        assertEquals(true, itemFound);

    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldStartCrawling() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        String action = "some action";
        //act
        webCrawler.crawl(action);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionChooseAction() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.rootURL = "https://localhost/tci";

        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);

        //act
        webCrawler.chooseAction();
    }

    @Test
    public void shouldChooseActionAll() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.rootURL = "https://localhost/tci";

        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);

        //act
        webCrawler.chooseAction();

        //assert
    }

    @Test
    public void shouldChooseActionSpecific() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.rootURL = "https://localhost/tci";
        webCrawler.searchPhrase = "Clean Code: A Handbook of Agile Software Craftsmanship";


        //act
        webCrawler.crawl("specific");

        //assert

    }

    @Test
    public void shouldChooseActionSpecificNotFindItem() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.rootURL = "https://localhost/tci";
        webCrawler.searchPhrase = "some random item";

        //act
        webCrawler.crawl("specific");

        //assert
       assertEquals(false, webCrawler.itemFound);
    }

//    @Test
//    public void shouldStartCrawling(){
//
//    }

    @Test
    public void shouldGetItemsQueue() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        Queue<String> expected = new LinkedList<>();
        //act
        Queue<String> actual = webCrawler.getItemsQueue();

        //assert
        assertEquals(expected, actual);
    }
}
