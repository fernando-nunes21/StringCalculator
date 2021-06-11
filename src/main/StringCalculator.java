package main;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;

public class StringCalculator implements StringCalculatorIntarface{
    private ArrayList<String> numbers = new ArrayList<>();
    private String delimiter;

    public String add(String numbers){
        String[] separeNumbers;
        String response = "";
        response = validationStringNumbers(numbers);
        if(response != ""){ return response; }
        this.delimiter = extractInputDelimiter(numbers);
        numbers = removeDelimiter(numbers,this.delimiter.charAt(0));
        separeNumbers = numbers.split(this.delimiter);
        separeNumbers = emptyStringAfterDelimiterResolve(separeNumbers);
        for(int i=0;i<separeNumbers.length;i++){
            this.numbers.add(separeNumbers[i]);
        }
        return sum();
    }

    private String sum(){
        Double sum = 0.0;
        String result="";

        for (int i=0;i<this.numbers.size();i++){
            sum+= Double.parseDouble(this.numbers.get(i));
        }
        result = String.format("%.1f", sum);
        if(result.contains(",0")){
            Integer convert = sum.intValue();
            result = convert.toString();
        }

        return result;
    }

    private String  validationStringNumbers(String numbers) {
        int pos=0;
        if (numbers.equals("")){
            return "0";
        }
        if (numbers.contains(",\\n") || numbers.contains("\\n,")) {
            for (int i=0;i<numbers.length();i++){
                if(numbers.charAt(i) == '\\'){
                    pos = i;
                }
            }
            return "Number expected but '\\n' found at position "+pos+".";
        }
        else if(numbers.charAt(numbers.length()-1) == ','){
            return "Number expected but EOF found.";
        }
        return "";
    }

     private String removeDelimiter(String numbers, char delimiter) {
        numbers = numbers.replace('/',' ');
        numbers = numbers.replace('/',' ');
        numbers = numbers.replace('\\',' ');
        numbers = numbers.replace('n', delimiter);
        return numbers;
     }

     private String extractInputDelimiter(String numbers){
        StringBuilder delimiter= new StringBuilder();
        if(numbers.contains("//")) {
            int positionstart = numbers.lastIndexOf("/");
            int posfinal = numbers.indexOf("\n");
            for (int i = positionstart+1; i < posfinal; i++) {
                delimiter.append(numbers.charAt(i));
            }
        }
        else{
            delimiter.append(",");
        }

        return delimiter.toString();
     }

     private String[] emptyStringAfterDelimiterResolve(String[] separeNumbers){
        for (int i=0; i<separeNumbers.length; i++){
            if(separeNumbers[i].equals("  ")){
               separeNumbers[i] = "0";
            }
        }
        return separeNumbers;
     }
}
