package main.java.com.dynamicProgramming;

public class CoinChangeExactCoins {
    public int getWays(int[] cDenominations, int amt, int numOfCoin){
        int[][] cache = new int[amt+1][amt+1];
        cache[0][0] = 1;
        for(int i=0; i<=amt; i++){
            for(int j=0; j<=numOfCoin; j++){
                if(i>0 && j==0){
                    cache[i][j]=0;
                    continue;
                }
                for(int coin : cDenominations){
                    if(i-coin>=0){
                        cache[i][j]+=cache[i-coin][j-1];
                    }
                }
            }
        }
        printCache(cache);
        return cache[amt][numOfCoin];
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
        CoinChangeExactCoins exactCoins = new CoinChangeExactCoins();
        int amt = 7;
        int numOfCoins = 3;
        int[] cDenominations = {1, 2, 3, 5};
        System.out.println("Number of ways to give change for given amount of " + amt + " by using exact "
                + numOfCoins + " coins are " + exactCoins.getWays(cDenominations, amt, numOfCoins));
    }
}
