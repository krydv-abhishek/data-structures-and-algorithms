package org.abhishek.arrays;

import java.util.HashMap;
import java.util.Map;


public class IntegerToRoman {

    public String intToRoman(int num) {

        Map<Integer, String> constantMap = new HashMap<Integer, String>();
        constantMap.put(1000, "M");
        constantMap.put(900, "CM");
        constantMap.put(500, "D");
        constantMap.put(400, "CD");
        constantMap.put(100, "C");
        constantMap.put(90, "XC");
        constantMap.put(50, "L");
        constantMap.put(40, "XL");
        constantMap.put(10, "X");
        constantMap.put(9, "IX");
        constantMap.put(5, "V");
        constantMap.put(4, "IV");
        constantMap.put(1, "I");

        int[] constants = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String answer = "";


        for(int constant : constants) {
            
            if(num >= constant) {
        
                answer = answer.concat(getNRepititonOfLiteral(constantMap.get(constant), num / constant));
                num = num % constant;
            }


        }

        return answer;
       

    }

    private String getNRepititonOfLiteral(String literal, int n) {
        String answer = literal;
        while (n > 1) {
            answer = answer.concat(literal);
            n--;
        }
        return answer;
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(100));
        System.out.println(integerToRoman.intToRoman(1000));

        System.out.println(integerToRoman.intToRoman(1999));

        System.out.println(integerToRoman.intToRoman(1));

    }

}
