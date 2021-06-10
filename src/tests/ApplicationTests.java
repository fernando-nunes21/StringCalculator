package tests;

import junit.framework.TestCase;
import main.StringCalculator;

public class ApplicationTests extends TestCase {
    public void testSumOneNumber(){
        assertEquals("2", new StringCalculator().add("2"));
    }

    public void testSumEmpty(){
        assertEquals("0", new StringCalculator().add(""));
    }

    public void testTwoIntegerNumbers(){
        assertEquals("3", new StringCalculator().add("1,2"));
    }

    public void testTowDoubleNumbers(){
        assertEquals("3,3", new StringCalculator().add("1.1,2.2"));
    }

}
