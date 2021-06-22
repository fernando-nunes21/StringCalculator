package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator{
    private final ArrayList<String> numbers = new ArrayList<>();

    public String addToSum(String inputValue){
        String operationResult;
        operationResult = add(inputValue);
        if(operationResult.equals("")){
            operationResult = sum();
        }
        return operationResult;
    }

    public String addToMulti(String inputValue){
        String operationResult;
        operationResult = add(inputValue);
        if(operationResult.equals("")){
            operationResult = multi();
        }
        return operationResult;
    }

    private String add(String inputValue){
        List<String> numbersFromString;
        String response = validationStringNumbers(inputValue);
        if(!response.equals("")){
            return response;
        }
        String delimiter = extractInputDelimiter(inputValue);
        inputValue = removeDelimiter(inputValue, delimiter.charAt(0));
        numbersFromString = Arrays.asList(inputValue.split(delimiter));
        if(!delimiter.equals(",")){
            numbersFromString = removeEmptySpaces(numbersFromString);
        }
        this.numbers.addAll(numbersFromString);
        response = validatorNegativeNumbers();
        if (!response.equals("")){
            return response;
        }
        return "";
    }

    private String  validationStringNumbers(String inputValue) {
        int pos=0;
        if (inputValue.equals("")){
            return "0";
        }
        if (inputValue.contains(",\\n") || inputValue.contains("\\n,")) {
            for (int i=0;i<inputValue.length();i++){
                if(inputValue.charAt(i) == '\\'){
                    pos = i;
                }
            }
            return "Number expected but '\\n' found at position "+pos+".";
        }
        else if(inputValue.charAt(inputValue.length()-1) == ','){
            return "Number expected but EOF found.";
        }
        return "";
    }

    private String removeDelimiter(String inputValue, char delimiter) {
        inputValue = inputValue.replace('/',' ');
        inputValue = inputValue.replace('/',' ');
        inputValue = inputValue.replace('\\', ' ');
        inputValue = inputValue.replace('n', delimiter);
        return inputValue;
    }

    private String extractInputDelimiter(String inputValue){
        StringBuilder delimiter= new StringBuilder();
        if(inputValue.contains("//")) {
            int startPosition = inputValue.lastIndexOf("/");
            int finalPosition = inputValue.indexOf("\n");
            for (int i = startPosition+1; i < finalPosition; i++) {
                delimiter.append(inputValue.charAt(i));
            }
        }
        else{
            delimiter.append(",");
        }
        return delimiter.toString();
    }

    private List<String> removeEmptySpaces(List<String> numbersFromString){
        while(numbersFromString.get(0).contains(" ")){
            numbersFromString.set(0, numbersFromString.get(0).replace(' ', '0'));
        }
        return numbersFromString;
    }

    private String validatorNegativeNumbers(){
        StringBuilder response = new StringBuilder();
        for (String number : this.numbers) {
            if (Double.parseDouble(number) < 0) {
                if (response.toString().equals("")) {
                    response = new StringBuilder("Negative not allowed :");
                }
                response.append(" ").append(number);
            }
        }
        return response.toString();
    }

    private String sum(){
        Double sum = 0.0;
        String result;

        for (String number : this.numbers) {
            sum += Double.parseDouble(number);
        }
        result = String.format("%.1f", sum);
        if(result.contains(",0")){
            Integer convert = sum.intValue();
            result = convert.toString();
        }

        return result;
    }

    private String multi(){
        Double multi = 1.0;
        String result;
        for (String number : this.numbers) {
            multi = multi * Double.parseDouble(number);
        }
        result = String.format("%.1f", multi);
        if(result.contains(",0")){
            Integer convert = multi.intValue();
            result = convert.toString();
        }
        return result;
    }

}
