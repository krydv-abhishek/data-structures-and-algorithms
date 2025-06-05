package org.abhishek.bitmanipulation;

public class AddBinary {

    public static String addBinary(String a, String b) {


        if(a.length() > b.length()) {
            return addBinary(b, a);
        }

        char[] achar =a.toCharArray();
        char[] bchar = b.toCharArray();

        int c = 0;
        int bi = bchar.length-1;
        StringBuilder answer = new StringBuilder();

        for(int i=achar.length-1 ; i>=0 ; i--) {
            if (achar[i]=='1' && bchar[bi]=='1') {
                if(c==1) {
                    answer.append("1");
                } else {
                    answer.append("0");
                }
                c=1;
            } else if (achar[i]=='1' || bchar[bi]=='1') {
                if(c==1) {
                    answer.append("0");
                } else {
                    answer.append("1");
                }
            } else {
                if(c==1) {
                    answer.append("1");
                    c=0;
                } else {
                    answer.append("0");
                }
            }
            bi--;
        }

        while(bi>=0) {
            if(bchar[bi]=='1') {
                if(c==1) {
                    answer.append("0");
                } else {
                    answer.append("1");
                }
            } else {
                if(c==1) {
                    answer.append("1");
                    c=0;
                } else {
                    answer.append("0");
                }
            }
            bi--;
        }
        if(c==1) {
            answer.append("1");
        }

        return answer.reverse().toString();


    }

    public static void main(String[] args) {
        System.out.println(addBinary("101111", "10"));
    }
}
