package org.abhishek.arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0) {
            return "";
        } 

        int index = 0;
        while(index < strs[0].length()) {

            char prefix = strs[0].charAt(index);
            int check = index;
            for(int i=0; i< strs.length; i++) {
                
                if(strs[i].length() > index && strs[i].charAt(index) == prefix) {
                    if(i == strs.length -1) {
                        index ++;
                    }
                    continue;
                } else {
                    break;
                }
    
            }
            if(check == index){
                break;
            }

        }

        return strs[0].substring(0, index);
       
        
    }

    public static void main(String[] args) {
 
        String[] strs = {"hfg", "ifgdsdbdfb","jfg","fgg"};
        System.out.println(longestCommonPrefix(strs));

    }
}
