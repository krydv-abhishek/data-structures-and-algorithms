package org.abhishek.stack;

import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String s) {

        int ans = 0;
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(sign);

        for (Character ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '(') {
                stack.push(sign);
            } else if (ch == ')') {
                stack.pop();
            } else if (ch == '+' || ch == '-') {
                ans += sign * num;
                sign = (ch == '+' ? 1 : -1) * stack.peek();
                num = 0;
            }
        }
        return ans + sign * num;
    }


    public static void main(String[] args) {

        System.out.println(calculate("-(3+2)"));

    }
}
