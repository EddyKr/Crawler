import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    public void addsDifferentItemsToItemList() {
        //arrange
        WebCrawler webCrawler = new WebCrawler();

        Book mb = mock(Book.class);
        Movie mm = mock(Movie.class);
        Music mmu = mock(Music.class);

        //act
        webCrawler.itemsList.add(mb);
        webCrawler.itemsList.add(mm);
        webCrawler.itemsList.add(mmu);

        //assert
        assertEquals(3,webCrawler.itemsList.size());

    }

}
