package main.java.com.stack;

import java.util.Stack;

public class ReverseStack {
    static Stack<Integer> stack = new Stack<>();

    private void insertLast(int ele){
        if(stack.isEmpty()){
            stack.push(ele);
        }else{
            int x = stack.pop();
            insertLast(ele);
            stack.push(x);
        }
    }

    private void reverse(){
        if(!stack.isEmpty()){
            int x = stack.pop();
            reverse();
            insertLast(x);
        }
    }

    public static void main(String[] args){
        ReverseStack reverseStack = new ReverseStack();
        int[] arr = {1,2,3,4};
        for(int ele : arr){
            stack.push(ele);
        }
        reverseStack.print();
        reverseStack.reverse();
        reverseStack.print();

    }

    private void print(){
        System.out.println("For top element = " + stack.peek());
        System.out.println(stack);
    }
}
