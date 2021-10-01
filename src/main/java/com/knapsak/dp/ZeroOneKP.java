package main.java.com.knapsak.dp;

public class ZeroOneKP {

    private int getMaxValue(int[] wt, int[] val, int maxWt){
        int noWt = wt.length;
        int[][] cache = new int[noWt+1][maxWt+1];

        for(int i=0; i<=noWt; i++){
            for(int j=0; j<=maxWt; j++){
                if(i==0 || j==0){
                    cache[i][j]=0;
                }else if (wt[i-1]<=j){
                    cache[i][j] = Math.max(cache[i-1][j],
                            val[i-1] + cache[i-1][j-wt[i-1]]);
                }else{
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[noWt][maxWt];
    }

    public static void main(String[] args){
        ZeroOneKP kp = new ZeroOneKP();
        int[] val = {10, 15, 40};
        int[] wt = {1, 2, 3};
        int maxWt = 6;
        System.out.println("Max gain is " + kp.getMaxValue(wt, val, maxWt));
    }
}
