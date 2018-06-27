import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIAForInvalidYear(){
        Item item = new Item("Test", "Something", "SomeGenre", "SomeFormat", -5);
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
