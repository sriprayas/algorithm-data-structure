package main.java.com.dynamicProgramming;

public class ClimbingStairsVarStepsMemOptimized {
    public int getNumberOfSteps(int stairNumbers, int noOfFlightAllowed){
        int[] cache = new int[noOfFlightAllowed];
        cache[0] = 1;
        for(int i=1; i<=stairNumbers; i++){
            for(int j=1; j<noOfFlightAllowed; j++){
                if(i>=j) {
                    cache[i%noOfFlightAllowed]+=cache[(i - j)%noOfFlightAllowed];
                }
            }
        }
        return cache[stairNumbers%noOfFlightAllowed];
    }

    public static void main(String[] args){
        ClimbingStairsVarStepsMemOptimized stairs = new ClimbingStairsVarStepsMemOptimized();
        int stairNumber = 2;
        int noOfFlightAllowed = 3;
        System.out.println("No of steps required to climb " + stairNumber
                + " stairs with number of flight allowed " + noOfFlightAllowed + " is "
                + stairs.getNumberOfSteps(stairNumber, noOfFlightAllowed));
    }
}
