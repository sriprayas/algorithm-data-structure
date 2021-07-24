package main.java.com.stack;

import java.util.Stack;

public class NextGreaterElement {

    private void printNGE(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for(int i=1; i<arr.length; i++){
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                print(stack.peek(), arr[i]);
                stack.pop();
            }
            stack.push(arr[i]);
        }

        while(!stack.isEmpty()){
            print(stack.pop(), -1);
        }
    }

    private void print(int peek, int curr){
        System.out.println("For element " + peek + " next " +
                "greater element is " + curr);
    }

    public static void main(String[] args){
        NextGreaterElement nge = new NextGreaterElement();
        int[] arr = {13, 7, 6, 12};
        nge.printNGE(arr);
    }
}
