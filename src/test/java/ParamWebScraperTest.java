import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ParamWebScraperTest {



    @Parameterized.Parameters
    public static Collection<Object[]> testData(){

        Object[][] data = new Object[][]{
                {"http://localhost/tci/details.php?id=101",
                        new Book("A Design Patterns: Elements of Reusable Object-Oriented Software",
                                "Books",
                                "Tech",
                                "Paperback",
                                1994,
                                "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
                                "Prentice Hall",
                                "978-0201633610")},

                {"http://localhost/tci/details.php?id=201",
                new Movie("Forrest Gump",
                        "Movies",
                        "Drama",
                        "DVD",
                        1994,
                        "Robert Zemeckis",
                        "Winston Groom, Eric Roth",
                        "Tom Hanks, Rebecca Williams, Sally Field, Michael Conner Humphreys")},

                {"http://localhost/tci/details.php?id=304",
                new Music("The Very Thought of You",
                        "Music",
                        "Jaz",
                        "MP3",
                        2008,
                        "Nat King Cole")}
        };

        return Arrays.asList(data);
    }


    private String url;
    private Item itm;
    WebScraper wc;

    @Before
    public void setup(){
        wc = new WebScraper();

    }

    public ParamWebScraperTest(String url, Item itm){

        this.url = url;
        this.itm = itm;

    }


    @Test
    public void test() throws IOException {
        Document doc = Jsoup.connect(url).validateTLSCertificates(false).get();
        assertEquals((Object) itm.title,(Object) wc.itemMapper.mapItem(doc).title);
        assertEquals((Object) itm.category,(Object) wc.itemMapper.mapItem(doc).category);
    }
}