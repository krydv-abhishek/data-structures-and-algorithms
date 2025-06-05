package org.abhishek.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {

        List<String> answer = new ArrayList<>();
        backtrack(answer, n, "",0,0);
        return answer;

    }

    public static void backtrack(List<String> answer, int n,
                                 String current, int open, int close) {


        if (current.length() == 2 * n) {
            answer.add(current);
            return;
        }

        if(open<n) {
            backtrack(answer, n, current + '(', open+1, close);
        }
        if(close<open) {
            backtrack(answer, n, current + ')', open, close+1);
        }
    }


    public static void main(String[] args) {

        System.out.println(generateParenthesis(2));
    }
}
