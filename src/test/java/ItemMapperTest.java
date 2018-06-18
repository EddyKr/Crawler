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

    //Tests:
    //1.shouldMapItem
    //2.shouldCreateBookObject
    //3.shouldCreateMovieObject
    //4.shouldCreateMusicObject

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

    //1
    //input: Item
    //expected: item to get mapped
    //output: item getts mapped
    @Test
    public void shouldMapItem() {
        //arrange
        when(itemMapper.mapItem(doc)).thenReturn(item);

        //act
        Item actual = itemMapper.mapItem(doc);

        //assert
        assertThat(actual, instanceOf(Item.class));
    }

    //2
    //input: Book item
    //expected: to create book object (itme)
    //output: item is an object of a Book class
    @Test
    public void shouldCreateBookObject() {
        //arrange
        when(itemMapper.createBookObject(doc)).thenReturn(book);

        //act
        Book actual = itemMapper.createBookObject(doc);

        //assert
        assertThat(actual, instanceOf(Book.class));
    }

    //3
    //input: Movie item
    //expected: to create movie object (itme)
    //output: item is an object of a Movie class
    @Test
    public void shouldCreateMovieObject() {
        //arrange
        when(itemMapper.createMovieObject(doc)).thenReturn(movie);

        //act
        Movie actual = itemMapper.createMovieObject(doc);

        //assert
        assertThat(actual, instanceOf(Movie.class));
    }

    //4
    //input: Music item
    //expected: to create music object (itme)
    //output: item is an object of a Music class
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