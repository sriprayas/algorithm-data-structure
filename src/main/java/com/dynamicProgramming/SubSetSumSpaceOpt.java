package main.java.com.dynamicProgramming;

public class SubSetSumSpaceOpt {
    private boolean isSubSet(int[] set, int setLen, int targetSum){
        {
            boolean[][] subSet = new boolean[2][targetSum+1];
            for(int i=0; i<2; i++){
                subSet[i][0] = true;
            }
            for(int i=1; i<=setLen; i++){
                for(int sum=1; sum<=targetSum; sum++){
                    subSet[i%2][sum] = subSet[(i-1)%2][sum];
                    if(sum-set[(i-1)]>=0){
                        subSet[i%2][sum] = ( subSet[(i-1)%2][sum] ||
                                subSet[(i-1)%2][sum-set[(i-1)]]);
                    }
                }
            }
            printCache(subSet);
            return subSet[setLen%2][targetSum];
        }
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
        SubSetSumSpaceOpt subSet = new SubSetSumSpaceOpt();
        int[] set = {4, 1, 10, 12, 5, 2 };
        int targetSum = 9;
        if(subSet.isSubSet(set, set.length, targetSum)){
            System.out.println("Found subset with asked sum");
        }else{
            System.out.println("Didn't found the subset");
        }
    }
}