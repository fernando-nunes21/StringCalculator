package main;

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
        if(!this.delimiter.equals(",")){ separeNumbers = removeEmptySpaces(separeNumbers); }

        for(int i=0;i<separeNumbers.length;i++){
            this.numbers.add(separeNumbers[i]);
        }
        response = validatorNegativeNumbers();
        if (response != ""){ return response; }
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
        numbers = numbers.replace('\\', ' ');
        numbers = numbers.replace('n', delimiter);
        return numbers;
     }

     private String extractInputDelimiter(String numbers){
        StringBuilder delimiter= new StringBuilder();
        if(numbers.contains("//")) {
            int positionstart = numbers.lastIndexOf("/");
            int posfinal = numbers.indexOf("\n");
            System.out.println(numbers);
            System.out.println(posfinal);
            System.out.println(positionstart);
            for (int i = positionstart+1; i < posfinal; i++) {
                System.out.println(numbers.charAt(i));
                delimiter.append(numbers.charAt(i));
            }
        }
        else{
            delimiter.append(",");
        }

        return delimiter.toString();
     }

     private String[] removeEmptySpaces(String[] separeNumbers){
        while(separeNumbers[0].contains(" ")){
            separeNumbers[0] = separeNumbers[0].replace(' ','0');
        }
        return separeNumbers;
     }

    private String validatorNegativeNumbers(){
        String response = "";
        for (int i=0;i<this.numbers.size();i++){
            if(Double.parseDouble(this.numbers.get(i)) < 0){
                if(response==""){
                    response = "Negative not allowed :";
                }
                response = response+" "+this.numbers.get(i);
            }
        }
        return response;
    }

    private String mult(){
        Double mult = 0.0;
        String result="";

        for (int i=0;i<this.numbers.size();i++){
            mult+= Double.parseDouble(this.numbers.get(i));
        }
        result = String.format("%.1f", mult);
        if(result.contains(",0")){
            Integer convert = mult.intValue();
            result = convert.toString();
        }

        return result;
    }

}
