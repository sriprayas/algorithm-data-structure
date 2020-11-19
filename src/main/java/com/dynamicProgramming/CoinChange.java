package main.java.com.dynamicProgramming;

public class CoinChange {
    public int getWays(int[] cDenominations, int amt){
        int[] cache = new int[amt+1];
        cache[0] = 1;
        for(int i=1; i<=amt; i++){
            for(int j=0; j<cDenominations.length; j++){
                if((i-cDenominations[j])>-1) {
                    cache[i]+=cache[i - cDenominations[j]];
                }
            }
        }
        return cache[amt];
    }

    public static void main(String[] args){
        CoinChange coins = new CoinChange();
        int amt = 4;
        int[] cDenominations = {1, 2, 5, 10};
        System.out.println("Number of ways to give change for given amount of "
                + amt + " is " + coins.getWays(cDenominations, amt));
    }
}
