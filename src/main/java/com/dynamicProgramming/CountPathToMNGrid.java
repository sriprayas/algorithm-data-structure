package main.java.com.dynamicProgramming;

public class CountPathToMNGrid {
    public int countPath(int m, int n){
        int[][] cache = new int[m][n];
        cache[0][0] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i>0 && j>0){
                    cache[i][j] = cache[i-1][j] + cache[i][j-1];
                }else if(i>0) {
                    cache[i][j] = cache[i-1][j];
                }else if(j>0){
                    cache[i][j] = cache[i][j-1];
                }
            }
        }
        printCache(cache, m, n);
        return cache[m-1][n-1];
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
        int rows = 3;
        int coll = 3;
        CountPathToMNGrid grid = new CountPathToMNGrid();
        System.out.println("Number of ways to reach cell " + (rows-1) + " x "
                + (coll-1) + " is " + grid.countPath(rows, coll));
    }
}
