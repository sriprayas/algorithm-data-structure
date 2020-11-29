package main.java.com.dynamicProgramming;

public class CoinChangeMin {
    public int getWays(int[] cDenominations, int amt){
        int[] cache = new int[amt+1];
        cache[0] = 0;
        for(int i=1; i<=amt; i++){
            cache[i] = Integer.MAX_VALUE;

            for(int j=0; j<cDenominations.length; j++){
                if((i-cDenominations[j])>-1) {
                    int tmp = cache[i-cDenominations[j]];
                    if(tmp!=Integer.MAX_VALUE && ( (1+tmp) < cache[i]) ) {
                        cache[i] = 1 + tmp;
                    }
                }
            }
        }
        return cache[amt];
    }

    public static void main(String[] args){
        CoinChangeMin minCoins = new CoinChangeMin();
        int[] cDenominations = {15, 4, 3};
        int amt = 56;
        System.out.println("Minimum amount of coins required" +
                " to make a change for amount of " +
                amt + " is " + minCoins.getWays(cDenominations, amt));
    }
}
