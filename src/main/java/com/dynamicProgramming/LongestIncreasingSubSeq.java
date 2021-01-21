package main.java.com.dynamicProgramming;

public class LongestIncreasingSubSeq {

    private int getLength(int[] arr) {
        int len = arr.length;
        int[] cache = new int[len];
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j] &&
                        cache[i]<cache[j]+1){
                    cache[i] = cache[j]+1;
                }
            }
        }
        int max = 0;
        for(int i=0; i<cache.length; i++) {
            if(max<cache[i]) {
                max=cache[i];
            }
        }
        print(cache);
        return max+1;
    }

    private void print(int[] arr){
        for(Integer e : arr){
            System.out.print(e + " ");
        }
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args){
        int[] arr = {10, 20, 1, 30};
        LongestIncreasingSubSeq subSeq = new LongestIncreasingSubSeq();
        System.out.println("Longest increasing sub seq length is " + subSeq.getLength(arr));
    }
}
