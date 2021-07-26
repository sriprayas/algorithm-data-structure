package main.java.com.stack.implementation;

public class StackFromArray {
    int[] stack;

    private void push(int ele){
        if(stack==null){
            stack = new int[1];
        }else{
            int[] tmp = new int[stack.length+1];
            System.arraycopy(stack, 0, tmp, 1, stack.length);
            stack = tmp;
        }
        stack[0] = ele;
        System.out.println("Element added to stack");
    }

    private int pop(){
        if(stack.length==0) {
            return -1;
        }
        int res = stack[0];
        int[] tmp = new int[stack.length-1];
        System.arraycopy(stack, 1, tmp, 0, stack.length-1);
        stack = tmp;
        return res;
    }

    private int peek(){
        if (stack.length==0) {
            return -1;
        }
        else {
            return stack[0];
        }
    }

    private boolean isEmpty(){
        if(stack.length==0) {
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        StackFromArray stack = new StackFromArray();
        int[] inp = {1,7,5,4,9,3,4,8};
        for(int ele : inp){
            stack.push(ele);
        }
        System.out.println(stack.pop());

        System.out.println(stack.peek());

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
