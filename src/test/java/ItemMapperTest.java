import netscape.javascript.JSObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.jsoup.nodes.Document;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemMapperTest {
    private ItemMapper itemMapper = mock(ItemMapper.class);
    private Item item = mock(Item.class);
    private Book book = mock(Book.class);
    private Movie movie = mock(Movie.class);
    private Music music = mock(Music.class);
    private Document doc = mock(Document.class);
    private static final String ELEMENT_TAG = "tbody";
    private static final String ELEMENT_TAG_2 = "td";
    private static final String CATEGORY = "Movies";

    @Before
    public void initialization(){
    }

    @Test
    public void shouldMapItem() {
        //arrange
        when(itemMapper.mapItem(doc)).thenReturn(item);

        //act
        Item actual = itemMapper.mapItem(doc);

        //assert
        assertThat(actual, instanceOf(Item.class));
    }

    @Test
    public void shouldCreateBookObject() {
//        String selectTable = "table";
//        String cssQuery = "div.media-details";
//        String title = "Test title";
//        String category = "Test category";
//        String genre = "Test genre";
//        String format = "Test format";
//        Integer year = 1990;
//        String authors = "Test authors";
//        String publisher = "Test publisher";
//        String isbn = "Test isbn";
//
//        Elements rows = mock(Elements.class);
        //arrange
        when(itemMapper.createBookObject(doc)).thenReturn(book);

        //act
        Book actual = itemMapper.createBookObject(doc);

        //assert
        assertThat(actual, instanceOf(Book.class));
    }

    @Test
    public void shouldCreateMovieObject() {
        //arrange

        when(itemMapper.createMovieObject(doc)).thenReturn(movie);

        //act
        Movie actual = itemMapper.createMovieObject(doc);

        //assert
        assertThat(actual, instanceOf(Movie.class));
    }

    @Test
    public void shouldCreateMusicObject() {
        //arrange
        when(itemMapper.createMusicObject(doc)).thenReturn(music);

        //act
        Music actual = itemMapper.createMusicObject(doc);

        //assert
        assertThat(actual, instanceOf(Music.class));
    }
}