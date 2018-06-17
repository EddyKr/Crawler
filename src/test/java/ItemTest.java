import netscape.javascript.JSObject;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {
    private Item itemTest= mock(Item.class);
    private JSObject jsonObject = mock(JSObject.class);

    @Before
    public void initialization(){
    }

    @Test
    public void shouldReturnJson() {
        //arrange
        when(itemTest.returnAsJSON()).thenReturn(jsonObject);

        //act
        JSObject actual = itemTest.returnAsJSON();

        //assert
        assertThat(actual, instanceOf(JSObject.class));
    }

}
