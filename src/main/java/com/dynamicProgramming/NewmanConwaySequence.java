package main.java.com.dynamicProgramming;

public class NewmanConwaySequence {

    private void getSeq(int n){
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        for(int i=3; i<=n; i++){
            cache[i] = cache[cache[i-1]] + cache[i-cache[i-1]];
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
        NewmanConwaySequence seq = new NewmanConwaySequence();
        int n = 10;
        seq.getSeq(n);
    }
}
