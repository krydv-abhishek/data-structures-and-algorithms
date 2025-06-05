package org.abhishek.arrays;

public class ReverseWordsInString {
    public static String reverseWords(String s) {

        String answer = "";

        for(int i=s.length()-1 ; i>=0 ;i--){
        
            if(s.charAt(i) == ' '){
                continue;
            } else {
                int j = i - 1;
                while(j>=0 && s.charAt(j) != ' ') {
                    j--;
                }
                answer = answer.concat(s.substring(j+1, i+1)).concat(" ");
                i = j + 1;
            }
        }        

        return answer.trim();
    }

    public static void main(String[] args) {
 
        String strs = "the sky is blue";
        System.out.println(reverseWords(strs));

    }
}
