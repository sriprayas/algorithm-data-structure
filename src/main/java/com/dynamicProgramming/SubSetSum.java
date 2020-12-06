package main.java.com.dynamicProgramming;

public class SubSetSum {
    private boolean isSubSetPresent(int[] set, int setLen, int totSum){
        boolean[][] subSet = new boolean[setLen+1][totSum+1];

        for(int i=0; i<=setLen; i++){
            subSet[i][0] = true;
        }
        for(int i=1; i<=setLen; i++){
            for(int sum=1; sum<=totSum; sum++){
                subSet[i][sum] = subSet[i-1][sum];
                if(sum-set[i-1]>=0){
                    subSet[i][sum] = ( subSet[i-1][sum] ||
                            subSet[i-1][sum-set[i-1]]);
                }
            }
        }
        printCache(subSet);
        return subSet[setLen][totSum];
    }

    private void printCache(boolean[][] subSet){
        for (int i = 0; i < subSet.length; i++) {
            for (int j = 0; j < subSet[0].length; j++) {
                System.out.print(subSet[i][j] + " | ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args){
        SubSetSum sub = new SubSetSum();
        int set[] = {7,5,1};
        int sum = 4;
        int n = set.length;
        if (sub.isSubSetPresent(set, n, sum) == true) {
            System.out.println("Found a subset"
                    + " with given sum");
        }else{
            System.out.println("No subset with"
                    + " given sum");
        }
    }
}