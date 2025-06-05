package org.abhishek.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Could have used stack to remove stack code
 */
public class MinStackImpl {
    public static class MinStack {

        int[] stack = new int[30000];
        Map<List<Integer>, Integer> hash = new HashMap<>();
        private int stackPos = 0;
        private int minValue = Integer.MAX_VALUE;


        public MinStack() {

        }

        public void push(int val) {
            stack[stackPos++] = val;
            minValue = Math.min(val, minValue);
            hash.put(List.of(val, stackPos - 1), minValue);
        }

        public void pop() {
            stackPos--;
            if (stackPos == 0) {
                minValue = Integer.MAX_VALUE;
                hash = new HashMap<>();
            }
            if (stack[stackPos] == minValue) {
                minValue = getMin();
            }
        }

        public int top() {
            return stack[stackPos - 1];
        }

        public int getMin() {
            return hash.get(List.of(stack[stackPos - 1], stackPos - 1));
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-10);
        minStack.push(14);

        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());

        minStack.push(-20);

        System.out.println(minStack.getMin());
        System.out.println(minStack.getMin());

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
        minStack.pop();

        minStack.push(10);
        minStack.push(-7);

        System.out.println(minStack.getMin());

        minStack.push(-7);

        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
    }
}
