import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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

//    @Test
//    public void shouldReadUrlWithoutSearchPhrase() {
//        //arrange
//        WebCrawler webCrawler = new WebCrawler();
//        DocumentHelper docHelper = mock(DocumentHelper.class);
//        String tag = "a";
//        String attribute = "abs:href";
//        String url = "http://localhost/tci/details.php?id=102";
//
//        //act
//        Boolean readResult =  webCrawler.readUrl(url,tag,attribute, docHelper);
//        int itemListResult = webCrawler.itemsList.size();
//        //assert
//        assertEquals(true, readResult);
//        assertEquals(1, itemListResult);
//    }

//    @Test
//    public void shouldReadUrlWithSearchPhrase() {
//        //arrange
//        WebCrawler webCrawler = new WebCrawler();
//        webCrawler.searchPhrase = "Clean Code: A Handbook of Agile Software Craftsmanship";
//        DocumentHelper docHelper = mock(DocumentHelper.class);
//        String tag = "a";
//        String attribute = "abs:href";
//        String url = "http://localhost/tci/details.php?id=102";
//
//        //act
//        Boolean readResult =  webCrawler.readUrl(url,tag,attribute, docHelper);
//        Boolean itemFound = webCrawler.itemFound;
//        //assert
//        assertEquals(false, readResult);
//        assertEquals(true, itemFound);
//
//    }

    @Test
    public void shouldCrawlAllItems() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        webCrawler.rootURL = "http://something.com";
        String action = "all";
        DocumentHelper docHelper = mock(DocumentHelper.class);
        Document document = Jsoup.parse("<div class=\"media-details\">\n" +
                "      <h1>The Lord of the Rings: The Fellowship of the Ring</h1>\n" +
                "      <table>\n" +
                "        <tbody><tr>\n" +
                "          <th>Category</th>\n" +
                "          <td>Movies</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Genre</th>\n" +
                "          <td>Drama</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Format</th>\n" +
                "          <td>Blu-ray</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Year</th>\n" +
                "          <td>2001</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <th>Director</th>\n" +
                "          <td>Peter Jackson</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Writers</th>\n" +
                "          <td>J.R.R. Tolkien, Fran Walsh, Philippa Boyens, Peter Jackson</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Stars</th>\n" +
                "          <td>Ron Livingston, Jennifer Aniston, David Herman, Ajay Naidu, Diedrich Bader, Stephen Root</td>\n" +
                "        </tr>\n" +
                "              </tbody></table>\n" +
                "    </div>");
        when(docHelper.getDocumentFromUrl(anyString())).thenReturn(document);

        //act
        webCrawler.crawl(action, docHelper);

        //assert
        assertEquals(1, webCrawler.itemsList.size());
        assertEquals("The Lord of the Rings: The Fellowship of the Ring", webCrawler.itemsList.get(0).title);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldStartCrawling() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();
        String action = "some action";
        DocumentHelper docHelper = mock(DocumentHelper.class);
        //act
        webCrawler.crawl(action, docHelper);
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
