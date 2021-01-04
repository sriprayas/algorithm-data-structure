package main.java.com.dynamicProgramming;

public class LongestCommonSubsequence {
    private int getLength(char[] x, char[] y, int m, int n){
        int[][] cache = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(x[i-1]==y[j-1]){
                    cache[i][j] = cache[i-1][j-1] + 1;
                }else{
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        return cache[m][n];
    }

    public static void main(String[] args){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        char[] x = str1.toCharArray();
        char[] y = str2.toCharArray();
        int m = str1.length();
        int n = str2.length();
        System.out.println("Longest comm sub seq is " + lcs.getLength(x, y, m, n));

    }
}
