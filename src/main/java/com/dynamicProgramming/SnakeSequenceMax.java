package main.java.com.dynamicProgramming;

public class SnakeSequenceMax {

    private void getMaxLength(int[][] grid){
        int[][] cache = new int[grid.length][grid[0].length];
        int maxLen = 0 ;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(i!=0 || j!=0) {
                    if (j>0 && Math.abs(grid[i][j - 1] - grid[i][j]) == 1) {
                        cache[i][j] = Math.max(cache[i][j], cache[i][j - 1] + 1);
                        if(maxLen<cache[i][j]){
                            maxLen=cache[i][j];
                        }
                    }
                    if (i>0 && Math.abs(grid[i - 1][j] - grid[i][j]) == 1) {
                        cache[i][j] = Math.max(cache[i][j], cache[i - 1][j] + 1);
                        if(maxLen<cache[i][j]){
                            maxLen=cache[i][j];
                        }
                    }
                }
            }
        }
        System.out.println("Max Len " + maxLen);
        print(cache);
    }

    private void print(int[][] cache){
        for(int i=0; i<cache.length; i++){
            for(int j=0; j<cache[0].length; j++){
                System.out.print(cache[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args){
        int[][] grid = {{9, 6, 5, 2},
                        {8, 7, 6, 5},
                        {7, 3, 1, 6},
                        {1, 1, 1, 7}};
        SnakeSequenceMax sequence = new SnakeSequenceMax();
        sequence.getMaxLength(grid);
    }
}
