package main.java.com.dynamicProgramming;

public class GoldMine {
    private int getMax(int[][] mines){
        int row = mines.length;
        int col = mines[0].length;
        int[][] cache = new int[row][col];

        for(int i=0; i<row; i++){
            cache[i][0] = mines[i][0];
        }
        for(int j=1; j<col; j++){
            for(int i=0; i<row; i++){
                int d1 = 0;
                int d2 = 0;
                int d3 = 0;
                if(i-1>=0){
                    d1 = cache[i-1][j-1];
                }
                if(i+1<row){
                    d2 = cache[i+1][j-1];
                }
                d3 = cache[i][j-1];
                cache[i][j] = mines[i][j] + Math.max(Math.max(d1, d2), d3);
            }
        }
        return getMaxCol(cache);
    }

    private int getMaxCol(int[][] arr){
        int max=0;
        int col = arr[0].length;
        for(int i=0; i<arr.length; i++){
            if(arr[i][col-1]>max){
                max = arr[i][col-1];
            }
        }
        return max;
    }

    public static void main(String[] args){
        GoldMine goldMines = new GoldMine();
        int[][] mines = { {10, 33, 13, 15},
                          {22, 21, 04, 1},
                          {5, 0, 2, 3},
                          {0, 6, 14, 2}
                        };
        System.out.println("Maximum gold amount is " + goldMines.getMax(mines));
    }
}
