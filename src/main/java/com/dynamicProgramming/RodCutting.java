package main.java.com.dynamicProgramming;

public class RodCutting {
    int[] price = {0,1,5,8,9,10,17,17,20,24,30};

    public int getOptimumProfit(int rodLen) {
        int[] priceCache = new int[rodLen+1];
        priceCache[0] = 0;

        for(int i=1; i<=rodLen; i++){
            int maxProfit = Integer.MIN_VALUE;
            for(int j=1; j<=i; j++){
                maxProfit = Integer.max(maxProfit,
                        (price[j] + priceCache[i-j]));
                priceCache[i] = maxProfit;
                print(priceCache);
            }
        }
        return priceCache[rodLen];
    }

    public static void main(String[] args){
        int rodLength = 5;
        RodCutting rodCutting = new RodCutting();
        System.out.println(rodCutting.getOptimumProfit(rodLength));
    }

    public void print(int[] cache){
        for(int ele : cache){
            System.out.print(ele + " ");
        }
        System.out.println(" ");
    }
}
