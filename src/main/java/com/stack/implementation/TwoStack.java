package main.java.com.stack.implementation;

public class TwoStack {
    int[] stack;
    int i;
    int j;

    TwoStack(int size){
        stack = new int[size];
        i=-1;
        j=size;
    }

    private void push1(int val){
        if(i<j-1){
            i++;
            stack[i] = val;
        }else{
            throw new RuntimeException("Size exhausted");
        }
    }

    private void push2(int val){
        if(i<j-1){
            j--;
            stack[j] = val;
        }else{
            throw new RuntimeException("Size exhausted");
        }
    }

    private void pop1(){
        if(i>=0){
            int res = stack[i];
            i--;
            System.out.println(res);
        }else{
            throw new RuntimeException("No more element left");
        }

    }

    private void pop2(){
        if(j<stack.length){
            int res = stack[j];
            j++;
            System.out.println(res);
        }else{
            throw new RuntimeException("No more element left");
        }
    }

    public static void main(String[] args){
        TwoStack twoStack = new TwoStack(5);
        twoStack.push1(5);
        twoStack.push2(10);
        twoStack.push2(15);
        twoStack.push1(11);
        twoStack.push2(7);
        twoStack.pop1();
        twoStack.push2(40);
        twoStack.pop2();
    }
}
