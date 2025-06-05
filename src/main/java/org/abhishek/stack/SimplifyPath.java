package org.abhishek.stack;

import java.util.Stack;


public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] paths = path.split("/");

        for (String str : paths) {
            if (str.isEmpty() || str.equals(".")) continue;
            if (str.equals("..")) {
                if(!stack.empty()) stack.pop();
            } else {
                stack.push(str);
            }
        }

        String simplifiedPath = "";
        while (!stack.isEmpty()) {
            simplifiedPath = ("/" + stack.pop()).concat(simplifiedPath);
        }
        return simplifiedPath.isEmpty() ? "/" : simplifiedPath;

    }


    public static void main(String[] args) {

        System.out.println(simplifyPath("/./"));

    }
}
