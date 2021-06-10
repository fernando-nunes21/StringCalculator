package tests;

import junit.framework.TestCase;
import main.StringCalculator;

public class ApplicationTests extends TestCase {
    public void testSumOneNumber(){
        assertEquals("2", new StringCalculator().add("2"));
    }
}
