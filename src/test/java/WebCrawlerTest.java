import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WebCrawlerTest {
    private WebCrawler webcrawler = mock(WebCrawler.class);
    private Item testItem = mock(Item.class);
    private Queue<String> itemsQueue = new LinkedList<>();
    private List<String> linksList = new ArrayList<>();
    private static final String API_URL = "https://localhost/tci";
    private static final String TAG = "a";
    private static final String ATTRIBUTE = "abs:href";
    private static final String ACTION = "all";

    @Before
    public void initialization(){
    }

    @Test
    public void shouldGetItemsQueue() {
        //arrange
        when(webcrawler.getItemsQueue()).thenReturn(itemsQueue);

        //act
        Queue<String> actual = webcrawler.getItemsQueue();
        Queue<String> expected = itemsQueue;

        //assert
        verify(webcrawler).getItemsQueue();
        assertEquals(expected,actual);
    }

    @Test
    public void shouldGetLinkList() {
        //arrange
        when(webcrawler.getLinksList()).thenReturn(linksList);

        //act
        List<String> actual = webcrawler.getLinksList();
        List<String> expected = linksList;

        //assert
        verify(webcrawler).getLinksList();
        assertEquals(expected,actual);
    }

    @Test public void shouldCrawlTest () throws IOException {
        //arrange


        //act
        webcrawler.crawl(API_URL);

        //assert
        verify(webcrawler).crawl(API_URL);
    }

    @Test
    public void shouldReadUrl() {
        //arrange
        WebScraper webScraper = mock(WebScraper.class);
        Document doc = mock(Document.class);
        Elements elements = mock(Elements.class);

        when(webScraper.checkItem(doc)).thenReturn(testItem);
        when(doc.select(TAG)).thenReturn(elements);

        //act
        webcrawler.readUrl(API_URL,TAG,ATTRIBUTE);

        //assert
        verify(webcrawler).readUrl(API_URL,TAG,ATTRIBUTE);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullReadUrl() {
        //arrange
        doThrow(NullPointerException.class).when(webcrawler).readUrl(isNull(),anyString(),anyString());

        //act
        webcrawler.readUrl(isNull(),anyString(),anyString());
    }
}
