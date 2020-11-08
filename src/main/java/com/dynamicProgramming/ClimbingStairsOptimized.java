package main.java.com.dynamicProgramming;

public class ClimbingStairsOptimized {
    public int getNumberOfWays(int stairNumber){
        int a = 1;
        int b = 1;
        int ways = 0;
        for(int i=2; i<=stairNumber; i++){
            ways = a + b;
            a = b;
            b = ways;
        }
        return ways;
    }

    public static void main(String[] args){
        ClimbingStairsOptimized stairsOptm = new ClimbingStairsOptimized();
        System.out.println("No of ways to climb stairs is "
                +stairsOptm.getNumberOfWays(10));
    }
}
