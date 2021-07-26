package main.java.com.stack.implementation;

import java.util.Stack;

public class SpecialStack {
    Stack<Integer> eleStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    private void push(int ele){
        if(minStack.isEmpty() || minStack.peek()>ele){
            minStack.push(ele);
        }
        eleStack.push(ele);
    }

    private int getMin(){
        return minStack.peek();
    }

    private int pop(){
        if(!minStack.isEmpty() && minStack.peek()==eleStack.peek()){
            minStack.pop();
        }
        return eleStack.pop();
    }

    public static void main(String[] args){
        SpecialStack spl = new SpecialStack();
        int[] arr = {18,19,29,16,15};
        for(int ele : arr){
            spl.push(ele);
        }
        System.out.println("Curr Head for stack " + spl.eleStack +
                " is " + spl.eleStack.peek());
        System.out.println("Min element is " + spl.getMin());
        spl.pop();
        // spl.pop();
        System.out.println("Min element is " + spl.getMin());
    }
}
