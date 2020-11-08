package main.java.com.dynamicProgramming;

public class ClimbingStairsVariableSteps {
    public int getNumberOfSteps(int stairNumbers, int noOfFlightAllowed){
        int[] cache = new int[stairNumbers+1];
        cache[0] = 1;
        cache[1] = 1;
        for(int i=2; i<=stairNumbers; i++){
            for(int j=1; j<=noOfFlightAllowed; j++){
                if(i>=j) {
                    cache[i] += cache[i - j];
                }
            }
        }
        return cache[stairNumbers];
    }

    public static void main(String[] args){
        ClimbingStairsVariableSteps stairs = new ClimbingStairsVariableSteps();
        int stairNumber = 5;
        int noOfFlightAllowed = 3;
        System.out.println("No of steps required to climb " + stairNumber
                + " stairs with number of flight allowed " + noOfFlightAllowed + " is "
                + stairs.getNumberOfSteps(stairNumber, noOfFlightAllowed));
    }
}
