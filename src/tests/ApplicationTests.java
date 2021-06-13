package tests;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.StringCalculator;

public class ApplicationTests extends TestCase {
    public void testSumReturnTwo(){
        assertEquals("2", new StringCalculator().add("2"));
    }

    public void testSumReturnZero(){
        assertEquals("0", new StringCalculator().add(""));
    }

    public void testSumReturnThree(){
        assertEquals("3", new StringCalculator().add("1,2"));
    }

    public void testSumReturnDouble(){
        assertEquals("3,3", new StringCalculator().add("1.1,2.2"));
    }

    public void testSumWithThreeNumbersReturnSix(){
        assertEquals("6", new StringCalculator().add("1,2,3"));
    }

    public void testSumWithManyNumbersReturn(){
        assertEquals("20", new StringCalculator().add("2.5,2.5,5,2,2,2,2,2"));
        assertEquals("100", new StringCalculator().add("10,20,20,10,10,10,5.5,5.5,9"));
    }

    public void testNewSeparatorReturnSix(){
        assertEquals("6", new StringCalculator().add("1\\n2,3"));
        assertEquals("6", new StringCalculator().add("1\\n2\\n3"));
    }

    public void testWrongNewSeparatorReturnError(){
        assertEquals("Number expected but '\\n' found at position 6.",new StringCalculator().add
                ("175.2,\\n35"));
        assertEquals("Number expected but '\\n' found at position 2.", new StringCalculator().add("1,\\n2,3"));
    }

    public void testMissNumberReturnError(){
        assertEquals("Number expected but EOF found.", new StringCalculator().add("1,2,"));
    }

    public void testDelimiterAndReturnThree(){
        assertEquals("3", new StringCalculator().add("//;\n1;2"));
    }

    public void testDelimiterAndReturnFive(){
        assertEquals("5", new StringCalculator().add("//sep\n2sep3"));
    }


    public void testNegativeNumbersReturnError(){
        assertEquals("Negative not allowed : -4 -5",new StringCalculator().add("2,-4,-5"));
    }





}
