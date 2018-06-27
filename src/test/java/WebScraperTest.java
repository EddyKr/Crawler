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
    public void shouldCheckItemBook() {
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
        assertEquals(actual.title, "Clean Code: A Handbook of Agile Software Craftsmanship");
        assertEquals(actual.category, "Books");
        assertEquals(actual.format, "Ebook");
    }

    @Test
    public void shouldCheckItemMovie() {
        //arrange
        WebScraper webScraper = new WebScraper();

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

        //act
        Item actual = webScraper.checkItem(document);

        //assert
        assertThat(actual,instanceOf(Movie.class));
        assertEquals(actual.title, "The Lord of the Rings: The Fellowship of the Ring");
        assertEquals(actual.category, "Movies");
        assertEquals(actual.format, "Blu-ray");
    }

    @Test
    public void shouldCheckItemMusic() {
        //arrange
        WebScraper webScraper = new WebScraper();

        Document document = Jsoup.parse("<div class=\"media-details\">\n" +
                "      <h1>Beethoven: Complete Symphonies</h1>\n" +
                "      <table>\n" +
                "        <tbody><tr>\n" +
                "          <th>Category</th>\n" +
                "          <td>Music</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Genre</th>\n" +
                "          <td>Clasical</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Format</th>\n" +
                "          <td>CD</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "          <th>Year</th>\n" +
                "          <td>2012</td>\n" +
                "        </tr>\n" +
                "                <tr>\n" +
                "          <th>Artist</th>\n" +
                "          <td>Ludwig van Beethoven\n</td>\n" +
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
        assertThat(actual,instanceOf(Music.class));
        assertEquals(actual.title, "Beethoven: Complete Symphonies");
        assertEquals(actual.category, "Music");
        assertEquals(actual.format, "CD");
    }

}
