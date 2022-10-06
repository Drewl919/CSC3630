import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalidromeRecurTest {
    @Test
    public void testSimple() {
        String s = "aba";
        assertTrue(InClass_9_13_Palidrome.isPalinRecur(s));
    }
    @Test
    public void testEvenChar() {
        String s = "abba";
        assertTrue(InClass_9_13_Palidrome.isPalinRecur(s));
    }
    @Test
    public void testNotPali() {
        String s = "abc";
        assertFalse(InClass_9_13_Palidrome.isPalinRecur(s));
    }
    @Test
    public void testEmpty() {
        String s = "";
        assertTrue(InClass_9_13_Palidrome.isPalinRecur(s));
    }
    @Test
    public void testOne() {
        String s = "a";
        assertTrue(InClass_9_13_Palidrome.isPalinRecur(s));
    }
}
