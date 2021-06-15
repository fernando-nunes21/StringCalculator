package tests;

import junit.framework.Assert;
import junit.framework.TestCase;
import main.StringCalculator;

public class ApplicationTests extends TestCase {
    public void testInputTwoShouldReturnTwo(){
        assertEquals("2", new StringCalculator().add("2"));
    }

    public void testInputemptyInputShouldReturnZero(){
        assertEquals("0", new StringCalculator().add(""));
    }

    public void testInputinputNumbersOneAndTwoShouldSumAndReturnThree(){
        assertEquals("3", new StringCalculator().add("1,2"));
    }

    public void testInputinputNumbersDoubleToSumAndShouldReturnDouble(){
        assertEquals("3,3", new StringCalculator().add("1.1,2.2"));
    }

    public void testInputinputThreeNumbersAndShouldReturnSumEqualToSix(){
        assertEquals("6", new StringCalculator().add("1,2,3"));
    }

    public void testInputinputManyNumbersDoubleAndIntegerToSumShouldReturn(){
        assertEquals("20", new StringCalculator().add("2.5,2.5,5,2,2,2,2,2"));
        assertEquals("100", new StringCalculator().add("10,20,20,10,10,10,5.5,5.5,9"));
    }

    public void testInputinputOneTwoThreeAndSeparatorShouldReturnSix(){
        assertEquals("6", new StringCalculator().add("1\\n2,3"));
        assertEquals("6", new StringCalculator().add("1\\n2\\n3"));
    }

    public void testInputinputWrongSeparatorShouldReturnErrorMessage(){
        assertEquals("Number expected but '\\n' found at position 6.",new StringCalculator().add
                ("175.2,\\n35"));
        assertEquals("Number expected but '\\n' found at position 2.", new StringCalculator().add("1,\\n2,3"));
    }

    public void testInputinputMissingNumberAfterSeparatorShouldReturnErrorEOF(){
        assertEquals("Number expected but EOF found.", new StringCalculator().add("1,2,"));
    }

    public void testInputinputDelimiteraAndOneAndTwoShouldReturnThree(){
        assertEquals("3", new StringCalculator().add("//;\n1;2"));
    }

    public void testInputinputDelimiterAndTwoAndThreeShouldReturnFive(){
        assertEquals("5", new StringCalculator().add("//sep\n2sep3"));
    }


    public void testInputinputNegativeNumberShouldReturnError(){
        assertEquals("Negative not allowed : -4 -5",new StringCalculator().add("2,-4,-5"));
    }

    public void testInputinputTwoAndTwoAndMultShouldReturnFour(){
        assertEquals("4", new StringCalculator().multiplication("2,2"));
    }



}
