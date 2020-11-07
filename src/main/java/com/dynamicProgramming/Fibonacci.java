package main.java.com.dynamicProgramming;

public class Fibonacci {
    public int getNthFibonacci(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3; i<n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }

    public static void main(String[] args){
        int n = 10;
        Fibonacci fib = new Fibonacci();
        System.out.println("Nth fibonacci number is " + fib.getNthFibonacci(n));
    }
}
