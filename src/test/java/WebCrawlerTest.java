import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WebCrawlerTest {
    private WebCrawler webcrawler = mock(WebCrawler.class);
    private Queue<String> itemsQueue = new LinkedList<>();
    private List<String> linksList = new ArrayList<>();
    private static final String API_URL = "https://localhost/tci";
    private static final String TAG = "a";
    private static final String ATTRIBUTE = "abs:href";

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

    @Test public void shouldCrawlTest () {
        //arrange

        //act
        webcrawler.crawl(API_URL);

        //assert
        verify(webcrawler).crawl(API_URL);
    }

    @Test
    public void shouldReadUrl() {
        //arrange

        //act
        webcrawler.readUrl(API_URL,TAG,ATTRIBUTE);

        //assert
        verify(webcrawler).readUrl(API_URL,TAG,ATTRIBUTE);
    }
}
