
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringManagerTest {
    @Test
    public void testApple() {
        String[] inString = {"Apples"};
        StringManager sm = new StringManager(inString);
        assertEquals(2, sm.howManyOfThis('p'));
    }

    @Test
    public void testMultiple() {
        String[] inString = {"Apples", "Peanutbutter", "pinaclep"};
        StringManager sm = new StringManager(inString);
        assertEquals(5, sm.howManyOfThis('p'));
    }

    @Test
    public void testNone() {
        String[] inString = {};
        StringManager sm = new StringManager(inString);
        assertEquals(0, sm.howManyOfThis('p'));
    }

}
