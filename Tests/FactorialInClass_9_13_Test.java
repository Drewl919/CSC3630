import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactorialInClass_9_13_Test {
    @Test
    public void RecursionSunnyDay() {
        int n = 5;
        int ret = InClass_9_8_Recur1.FactorialRecur(n);
        assertEquals(120, ret);
    }

    @Test
    public void testZero() {
        int n = 0;
        int res = InClass_9_8_Recur1.FactorialRecur(n);
        assertEquals(1, res);
    }

    @Test
    public void testOne() {
        int n = 1;
        int res = InClass_9_8_Recur1.FactorialRecur(n);
        assertEquals(1, res);
    }

    @Test
    public void testTwo() {
        int n = 2;
        int res = InClass_9_8_Recur1.FactorialRecur(n);
        assertEquals(2, res);
    }

    @Test
    public void testNegative() {
        int n = -2;
        int res = InClass_9_8_Recur1.FactorialRecur(n);
        assertEquals(1, res);
    }

    @Test
    public void testTooBig() {
        int n = 32;
        int res = InClass_9_8_Recur1.FactorialRecur(n);
//        assertEquals(1, res);
    }



}
