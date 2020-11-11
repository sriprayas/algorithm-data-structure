package main.java.com.dynamicProgramming;

public class ClimbingStairsMinCost {
    public int getMinCost(int stairNum, int[] cost){
        int[] cache = new int[stairNum+1];
        cache[0] = 0;
        cache[1] = cost[1];
        for(int i=2; i<=stairNum; i++){
            cache[i] = Math.min(cache[i-1], cache[i-2]) + cost[i];
        }
        return cache[stairNum];
    }

    public static void main(String[] args){
        int[] cost = {0, 3, 2, 4};
        int steps = cost.length-1;
        ClimbingStairsMinCost stairs = new ClimbingStairsMinCost();
        System.out.println("Min cost req to climb stairs for 2 step is "
                + stairs.getMinCost(steps, cost));
    }
}
