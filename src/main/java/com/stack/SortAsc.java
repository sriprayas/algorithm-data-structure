package main.java.com.stack;

import java.util.Stack;

public class SortAsc {

    private static Stack<Integer> stack = new Stack<>();

    private void logicalPush(int ele){
        if(stack.isEmpty() || stack.peek()>ele){
            stack.push(ele);
        }else{
            int top = stack.pop();
            logicalPush(ele);
            stack.push(top);
        }
    }

    private void sort(){
        if(!stack.isEmpty()){
            int top = stack.pop();
            sort();
            logicalPush(top);
        }
    }

    public static void main(String[] args){
        SortAsc sortAsc = new SortAsc();
        int[] arr = {4,1,6};
        for(int ele : arr){
             stack.push(ele);
        }
        System.out.println("Before sort head of stack is " +
                stack.peek() + " and stack is " + stack);
        sortAsc.sort();
        System.out.println("After sort head of stack is " +
                stack.peek() + " and stack is " + stack);
    }
}
