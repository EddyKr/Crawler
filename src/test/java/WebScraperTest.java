import org.jsoup.Jsoup;
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
    @Before
    public void initialization(){
    }

    //1
    //input:Item
    //expected: object to be instance of Item class
    //output: Item class object
    @Test
    public void shouldCheckItem() {
        //arrange
        WebScraper webScraper = new WebScraper();

        Document document = Jsoup.parse("<div class=\"media-details\">\n" +
                "      <h1>Clean Code: A Handbook of Agile Software Craftsmanship</h1>\n" +
                "      <table>\n" +
                "        <tbody><tr>\n" +
                "          <th>Category</th>\n" +
                "          <td>Books</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Genre</th>\n" +
                "          <td>Tech</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Format</th>\n" +
                "          <td>Ebook</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Year</th>\n" +
                "          <td>2008</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <th>Authors</th>\n" +
                "          <td>Robert C. Martin</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Publisher</th>\n" +
                "          <td>Prentice Hall</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>ISBN</th>\n" +
                "          <td>978-0132350884</td>\n" +
                "        </tr>\n" +
                "              </tbody></table>\n" +
                "    </div>");

        //act
        Item actual = webScraper.checkItem(document);

        //assert
        assertThat(actual,instanceOf(Book.class));
    }

}
