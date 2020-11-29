package main.java.com.dynamicProgramming;

public class BellNumbers {
    public int getWays(int n){
        int[][] cache = new int[n][n];
        // Base Case
        cache[0][0]=1;
        for(int i=1; i<n; i++){
            cache[i][0] = cache[i-1][i-1];
            for(int j=1; j<=i; j++){
                // Objective Function
               cache[i][j] = cache[i][j-1] + cache[i-1][j-1];
            }
        }
        return cache[n-1][n-1];
    }

    public static void main(String[] args){
        BellNumbers number = new BellNumbers();
        int n = 10;
        for(int i=1; i<=n; i++){
            System.out.println("Number of ways to partition a set containing " +
                    i + " elements is " + number.getWays(i));
        }
    }
}
