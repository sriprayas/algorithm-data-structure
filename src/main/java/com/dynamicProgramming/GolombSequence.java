package main.java.com.dynamicProgramming;

public class GolombSequence {
    private void getSequence(int n){
        int[] cache = new int[n+1];
        cache[1] = 1;

        for(int i=2; i<=n; i++){
            cache[i] = 1 + cache[i - cache[cache[i - 1]]];
        }
        print(cache);
    }

    private void print(int[] cache){
        for(int ele : cache){
            System.out.print(ele + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args){
        GolombSequence golomb = new GolombSequence();
        golomb.getSequence(15);
    }
}
