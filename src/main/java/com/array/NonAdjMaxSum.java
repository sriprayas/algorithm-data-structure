package main.java.com.array;

public class NonAdjMaxSum {

    private Integer getMaxSum(int[] arr){
        int inc = arr[0];
        int exc = 0;
        for(int i=1; i<arr.length; i++){
            int nInc = exc + arr[i];
            int nExc = Math.max(inc, exc);

            inc = nInc;
            exc = nExc;
        }
        return Math.max(inc, exc);
    }

    public static void main(String[] args){
        NonAdjMaxSum ele = new NonAdjMaxSum();
        int[] arr = {1, 20, 3};
        System.out.println(ele.getMaxSum(arr));
    }
}
