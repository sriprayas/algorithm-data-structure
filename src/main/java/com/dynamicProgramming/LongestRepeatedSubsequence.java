package main.java.com.dynamicProgramming;

public class LongestRepeatedSubsequence {

    private int getLength(char[] x, char[] y, int m, int n){
        int[][] cache = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(x[i-1]==y[j-1] && i!=j){
                    cache[i][j] = cache[i-1][j-1]+1;
                    System.out.println(x[i-1] + " " + y[j-1]);
                }else{
                    cache[i][j] = Math.max(cache[i-1][j], cache[i][j-1]);
                }
            }
        }
        return cache[m][n];
    }

    public static void main(String[] args){
        LongestRepeatedSubsequence subSq = new LongestRepeatedSubsequence();
        String str1 = "aabebcdd";
        char[] x = str1.toCharArray();
        int m  = str1.length();
        System.out.println("Length of longest repeated sub seq is " + subSq.getLength(x, x, m, m));
    }
}
