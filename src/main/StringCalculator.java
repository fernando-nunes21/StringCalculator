package main;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;

public class StringCalculator implements StringCalculatorIntarface{
    private ArrayList<String> numbers = new ArrayList<>();

    public String add(String numbers){
        String[] separeNumbers;
        String response = "";
        response = validationStringNumbers(numbers);
        if(response != ""){ return response; }
        numbers = removeDelimiter(numbers);
        separeNumbers = numbers.split(",");
        for(int i=0;i<separeNumbers.length;i++){ ;
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
            if(result.contains(",0")){
                Integer convert = sum.intValue();
                result = convert.toString();
            }
        }
        return result;
    }

    private String  validationStringNumbers(String numbers) {
        int pos=0;
        if (numbers.contains(",\\n") || numbers.contains("\\n,")) {
            for (int i=0;i<numbers.length();i++){
                if(numbers.charAt(i) == '\\'){
                    pos = i;
                }
            }
            return "Number expected but '\\n' found at position "+pos+".";
        }
        return "";
    }

     private String removeDelimiter(String numbers) {
        numbers = numbers.replace('\\',' ');
        numbers = numbers.replace('n', ',');
        return numbers;
     }
}
