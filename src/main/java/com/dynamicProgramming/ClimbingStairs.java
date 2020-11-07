package main.java.com.dynamicProgramming;

public class ClimbingStairs {
    public int getNumberOfWays(int stairNumber){
        int[] cache = new int[stairNumber+1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i=2; i<=stairNumber; i++){
            cache[i] = cache[i-1]+cache[i-2];
        }
        return cache[stairNumber];
    }

    public static void main(String[] args){
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println("Number of ways to climb is "
                + stairs.getNumberOfWays(10));
    }
}
