import com.google.gson.Gson;
import netscape.javascript.JSObject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {

    @Before
    public void initialization(){
    }

    @Test
    public void constructorShouldSetTitleAndCategory(){
        Item item = new Item("Test", "Something", "SomeGenre", "SomeFormat", 1993);

        assertEquals("Test", item.title);
        assertEquals("Something", item.category);
    }


    //1
    //input: Item
    //expected: return string in json format
    //output: returns string in json format
    @Test
    public void shouldReturnAsJSON() {
        //arrange
        Item item = new Item("Test", "Something", "SomeGenre", "SomeFormat", 1993);
        String expected = "{\"title\":\"Test\",\"category\":\"Something\",\"genre\":\"SomeGenre\",\"format\":\"SomeFormat\",\"year\":1993}";

        //act
        String result = item.returnAsJSON();

        //assert
        assertEquals(expected, result);
    }

}
