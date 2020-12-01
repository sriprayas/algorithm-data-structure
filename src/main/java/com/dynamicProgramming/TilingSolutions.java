package main.java.com.dynamicProgramming;

public class TilingSolutions {
    private int getWays(int n){
        int[] cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;
        for(int i=3; i<=n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }

    public static void main(String[] args){
        TilingSolutions solutions = new TilingSolutions();
        int n = 4;
        System.out.println("Number of ways a 2 x " +
                n + " can be tilled is " + solutions.getWays(n));
    }
}
