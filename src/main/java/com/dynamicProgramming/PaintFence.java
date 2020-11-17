package main.java.com.dynamicProgramming;

public class PaintFence {
    public int getCount(int totFence){
        int[][] cache = new int[totFence+1][2];
        cache[1][0] = 1;
        cache[1][1] = 1;
        cache[2][0] = 2;
        cache[2][1] = 2;

        for(int i=3; i<=totFence; i++){
            for(int j=0; j<2; j++){
                cache[i][j] = cache[i-1][1-j] + cache[i-2][1-j];
            }
        }
        printCache(cache, totFence+1, 2);
        return (cache[totFence][0] + cache[totFence][1]);
    }
    public void printCache(int[][] arr, int m, int n){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args){
        PaintFence fence = new PaintFence();
        int totStairs = 4;
        System.out.println("Total ways to paint fence of length "
                + totStairs + " is " + fence.getCount(totStairs));
    }
}
