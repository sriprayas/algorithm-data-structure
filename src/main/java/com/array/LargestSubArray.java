package main.java.com.array;

public class LargestSubArray {

    private int getSum(int[] arr){
        int maxSum =  arr[0];
        int currSum = arr[0];
        int startIdx = -1;
        int endIdx = -1;

        for(int i=1; i<arr.length; i++){
            if((currSum+arr[i])<arr[i]){
                currSum = arr[i];
                startIdx = i; // The place where we find arr[i] greater. Is where we start
            }else{
                currSum +=arr[i];
            }
            if(maxSum<currSum){
                endIdx = i; // The place where curr sum exceeds max sum is where we end
                maxSum = currSum;
            }
        }
        System.out.println("startIdx = " + startIdx + " endIdx " + endIdx);
        printEle(startIdx, endIdx, arr);
        return maxSum;
    }

    private void printEle(int startIdx, int endIdx, int[] arr) {
        System.out.println("Elements are ");
        while(startIdx<=endIdx){
            System.out.print(arr[startIdx] + " ");
            startIdx++;
        }
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args){
        LargestSubArray subArray = new LargestSubArray();
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is "
                + subArray.getSum(arr));
    }
}
