package org.abhishek.stack;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(',
                '}', '{',
                ']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == map.get(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {

        System.out.println(isValid("{(([])[])}"));

    }
}
