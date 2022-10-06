//  Author: Andrew Musielak
//  Course: CSC3630 Fall

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class RecursionHW1Test {

    //getSum Tests
    @Test
    public void getSumTest() {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList( 1, -10, 170, 27));
        assertEquals(188, RecursionHW1.getSum(numbs, numbs.size()-1));
    }
    @Test
    public void getSumBlankTest() {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList());
        assertEquals(0, RecursionHW1.getSum(numbs, numbs.size()-1));
    }
    @Test
    public void getSumSingleTest() {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList(1));
        assertEquals(1, RecursionHW1.getSum(numbs, numbs.size()-1));
    }
    @Test
    public void getSumBigTest() {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList(40, 473, 392, 29, 22371, 399, 215));
        assertEquals(23919, RecursionHW1.getSum(numbs, numbs.size()-1));
    }
    @Test
    public void getSumNegativeTest() {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList(40, 473, 392, 29, -22371, 399, 215));
        assertEquals(-20823, RecursionHW1.getSum(numbs, numbs.size()-1));
    }

    //getHowMany Tests
    @Test
    public void getHowManyTest1() {
        String inString = "She sells sea shells by the sea shore";
        assertEquals(7, RecursionHW1.getHowMany( inString, 's', 0, inString.length()-1));
    }
    @Test
    public void getHowManyTestBlank() {
        String inString = "";
        assertEquals(0, RecursionHW1.getHowMany( inString, 'a', 0, inString.length()-1));
    }
    @Test
    public void getHowManyTest3() {
        String inString = "This is a very generic statement to come up with";
        assertEquals(4, RecursionHW1.getHowMany( inString, 'i', 0, inString.length()-1));
        assertEquals(6, RecursionHW1.getHowMany( inString, 'e', 0, inString.length()-1));
    }
    @Test
    public void getHowManyCases() {
        String inString = "Peter Piper Pick a Pepper";
        assertEquals(3, RecursionHW1.getHowMany( inString, 'p', 0, inString.length()-1));
    }
}
