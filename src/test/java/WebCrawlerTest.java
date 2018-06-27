import com.sun.org.apache.xpath.internal.operations.Bool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

    @Test
    public void shouldStartCrawling() {

    }
}
