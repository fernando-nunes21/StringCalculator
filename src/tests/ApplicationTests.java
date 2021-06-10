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

    public void testTwoDoubleNumbers(){
        assertEquals("3,3", new StringCalculator().add("1.1,2.2"));
    }

    public void testSumThreeNumbers(){
        assertEquals("6", new StringCalculator().add("1,2,3"));
    }

    public void testManyNumbers(){
        assertEquals("20", new StringCalculator().add("2.5,2.5,5,2,2,2,2,2"));
        assertEquals("100", new StringCalculator().add("10,20,20,10,10,10,5.5,5.5,9"));
    }

    public void testNewSeparator(){
        assertEquals("6", new StringCalculator().add("1\\n,2,3"));
    }

    public void testWrongNewSeparator(){
        assertEquals("Number expected but '\\n' found at position 6.",new StringCalculator().add
                ("175.2,\\n35"));


    }


}
