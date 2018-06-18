import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WebCrawlerTest {

    //Tests:
    //1.shouldGetItemsQueue
    //2.shouldGetLinkList
    //3.shouldCrawlTest
    //4.shouldReadUrl
    //5.shouldThrowNullReadUrl

    private WebCrawler webcrawler = mock(WebCrawler.class);
    private Queue<String> itemsQueue = new LinkedList<>();
    private List<String> linksList = new ArrayList<>();
    private static final String API_URL = "https://localhost/tci";
    private static final String TAG = "a";
    private static final String ATTRIBUTE = "abs:href";

    @Before
    public void initialization(){
    }

    //1
    //input: calls queue getter
    //expected: receive list with queue
    //output: gets queue list
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

    //2
    //input: calls list getter
    //expected: receive list with links
    //output: gets links list
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

    //3
    //input: root url
    //expected: to crawl provided website
    //output: crawling verified
    @Test public void shouldCrawlTest () {
        //arrange

        //act
        webcrawler.crawl(API_URL);

        //assert
        verify(webcrawler).crawl(API_URL);
    }

    //4
    //input: website url, searched tag & attribute
    //expected: to read url according to tag and its attribute
    //output: verifies
    @Test
    public void shouldReadUrl() {
        //arrange

        //act
        webcrawler.readUrl(API_URL,TAG,ATTRIBUTE);

        //assert
        verify(webcrawler).readUrl(API_URL,TAG,ATTRIBUTE);
    }

    //5
    //input: null as url
    //expected: to raise NullPointerException
    //output: raises NullPointerException
    @Test(expected = NullPointerException.class)
    public void shouldThrowNullReadUrl() {
        //arrange
        doThrow(NullPointerException.class).when(webcrawler).readUrl(isNull(),anyString(),anyString());

        //act
        webcrawler.readUrl(isNull(),anyString(),anyString());
    }
}
