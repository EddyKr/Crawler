import org.junit.Before;
import org.junit.Test;
import org.jsoup.nodes.Document;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


public class WebScraperTest {
    private WebScraper webScraper = mock(WebScraper.class);
    private Item testItem = mock(Item.class);

    @Before
    public void initialization(){
    }

    @Test
    public void shouldCheckItem() {
        Document document = mock(Document.class);
        Item item = mock(Item.class);
        when(webScraper.checkItem(document)).thenReturn(item);

        //act
        Item actual = webScraper.checkItem(document);

        //assert
        assertThat(actual,instanceOf(Item.class));

    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerCheckItem () {
        //arrange
        doThrow(NullPointerException.class).when(webScraper).checkItem(isNull());

        //act
        webScraper.checkItem(isNull());
    }

}
