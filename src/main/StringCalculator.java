package main;

import java.util.ArrayList;

public class StringCalculator implements StringCalculatorIntarface{
    private ArrayList<String> numbers = new ArrayList<>();

    public String add(String numbers){
        String[] separeNumbers = numbers.split(",");
        for(int i=0;i<separeNumbers.length;i++){
            this.numbers.add(separeNumbers[i]);
        }

        return sum();
    }

    private String sum(){
        Double sum = 0.0;
        String result="";

        if(this.numbers.size() == 1 && this.numbers.get(0) == ""){
            return "0";
        }
        else{
            for (int i=0;i<this.numbers.size();i++){
                sum+= Double.parseDouble(this.numbers.get(i));
            }
            result = String.format("%.1f", sum);
            if(result.length()<4 && result.contains(",0")){
                Integer convert = sum.intValue();
                result = convert.toString();
            }
        }
        return result;
    }

}
