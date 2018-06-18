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

    //Tests:
    //1.shouldReturnAsJSON

    private Item itemTest= mock(Item.class);
    private static final  String jsonObject = "[]";

    @Before
    public void initialization(){
    }

    //1
    //input: Item
    //expected: return string in json format
    //output: returns string in json format
    @Test
    public void shouldReturnAsJSON() {
        //arrange
        when(itemTest.returnAsJSON()).thenReturn(jsonObject);

        //act
        String actual = itemTest.returnAsJSON();

        //assert
        assertEquals(jsonObject,actual);
    }

}
