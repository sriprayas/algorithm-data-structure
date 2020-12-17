package main.java.com.dynamicProgramming;

public class DominoesTilling31 {
    private int getWays(int n){
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        a[0] = 1;
        b[0] = 0;
        a[1] = 0;
        b[1] = 1;
        for(int i=2; i<=n; i++){
            a[i] = a[i-2] + 2*b[i-1];
            b[i] = a[i-1] + b[i-2];
        }
        return a[n];
    }

    public static void main(String[] args){
        DominoesTilling31 tilling = new DominoesTilling31();
        for(int n=2; n<=10; n++) {
            System.out.println("Total number of ways to tile 3 x "
                    + n + " is " + tilling.getWays(n));
        }
    }
}
