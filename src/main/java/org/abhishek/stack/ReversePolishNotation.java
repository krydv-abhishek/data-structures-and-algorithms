package org.abhishek.stack;

import java.util.Objects;
import java.util.Stack;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (Objects.equals(token, "+") || Objects.equals(token, "-")
                    || Objects.equals(token, "*") || Objects.equals(token, "/")) {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-(stack.pop() - stack.pop()));
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    default:
                        int divisor = stack.pop();
                        int dividend = stack.pop();
                        stack.push(dividend / divisor);
                        break;
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();

    }

    public static void main(String[] args) {

        //String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] tokens = {"4", "3", "-"};
        System.out.println(evalRPN(tokens));

    }
}
