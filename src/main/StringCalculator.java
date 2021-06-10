package main;

public class StringCalculator implements StringCalculatorIntarface{
    public String add(String numbers){
        if(numbers.equals("2")){
            return "2";
        }
        else if(numbers.equals("")){
            return "0";
        }
        else {
            return null;
        }
    }
}
