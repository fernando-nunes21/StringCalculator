package tests;

import main.StringCalculator;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ApplicationTests{
    @Test
    public void inputNumberTwoShouldSumAndReturnTwo(){
        assertEquals("2", new StringCalculator().addToSum("2"));
    }

    @Test
    public void emptyInputShouldSumAndReturnZero(){
        assertEquals("0", new StringCalculator().addToSum(""));
    }

    @Test
    public void inputNumbersOneAndTwoShouldSumAndReturnThree(){
        assertEquals("3", new StringCalculator().addToSum("1,2"));
    }

    @Test
    public void inputNumbersDoubleToSumAndShouldSumReturnDouble(){
        assertEquals("3,3", new StringCalculator().addToSum("1.1,2.2"));
    }

    @Test
    public void inputThreeNumbersAndShouldReturnSumEqualToSix(){
        assertEquals("6", new StringCalculator().addToSum("1,2,3"));
    }

    @Test
    public void inputManyDoubleAndIntegerNumbersToSumShouldReturnTwenty(){
        assertEquals("20", new StringCalculator().addToSum("2.5,2.5,5,2,2,2,2,2"));
    }

    @Test
    public void inputOneTwoThreeAndSeparatorShouldSumAndReturnSix(){
        assertEquals("6", new StringCalculator().addToSum("1\\n2,3"));
    }

    @Test
    public void inputWrongSeparatorShouldSumReturnErrorMessage(){
        assertEquals("Number expected but '\\n' found at position 6.",
                new StringCalculator().addToSum("175.2,\\n35"));
    }

    @Test
    public void inputMissingNumberAfterSeparatorShouldSumReturnErrorEOF(){
        assertEquals("Number expected but EOF found.", new StringCalculator().addToSum("1,2,"));
    }

    @Test
    public void inputCustomDelimiterAndNumbersOneAndTwoShouldSumReturnThree(){
        assertEquals("3", new StringCalculator().addToSum("//;\n1;2"));
    }

    @Test
    public void inputCustomDelimiterAndNumbersTwoAndThreeShouldSumReturnFive(){
        assertEquals("5", new StringCalculator().addToSum("//sep\n2sep3"));
    }

    @Test
    public void inputNegativeNumberShouldSumReturnError(){
        assertEquals("Negative not allowed : -4 -5", new StringCalculator().addToSum("2,-4,-5"));
    }

    @Test
    public void inputTwoAndTwoShouldMultiReturnFour(){
        assertEquals("4", new StringCalculator().addToMulti("2,2"));
    }

    @Test
    public void inputTwoAndTwoAndCustomDelimiterShouldMultiAndReturnFour(){
        assertEquals("9", new StringCalculator().addToMulti("3,3"));
    }

    @Test
    public void inputEmptyToMultiShouldReturnZero(){
        assertEquals("0", new StringCalculator().addToMulti(""));
    }
}