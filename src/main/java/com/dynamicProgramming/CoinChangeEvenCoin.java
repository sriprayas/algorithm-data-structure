package main.java.com.dynamicProgramming;

public class CoinChangeEvenCoin {
    public int getWays(int[] cDenominations, int amt){
        int[][] cache = new int[amt+1][2];
        cache[0][0] = 0;
        cache[0][1] = 1;

        for(int i=0; i<=amt; i++){
            for(int coin : cDenominations){
                if(i-coin>=0){
                    cache[i][0]+=cache[i-coin][1];
                    cache[i][1]+=cache[i-coin][0];
                }
            }
        }
        printCache(cache);
        return cache[amt][1];
    }

    private void printCache(int[][] cache){
        for(int i=0; i<cache.length; i++){
            for(int j=0; j<cache[0].length; j++){
                System.out.print(cache[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args){
        CoinChangeEvenCoin coinChange = new CoinChangeEvenCoin();
        int[] cDenominations = {1, 2, 5, 10};
        int amt = 4;
        System.out.println("Number of ways to give change for given amount of " +
                amt + " by using even coins are " + coinChange.getWays(cDenominations, amt));
    }

}
