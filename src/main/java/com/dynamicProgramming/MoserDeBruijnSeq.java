package main.java.com.dynamicProgramming;

public class MoserDeBruijnSeq {

    private void genSeq(int n){
        int[] cache = new int[n];
        cache[0] = 0;
        for(int i=1; i<n; i++){
            if(i%2==0){
                cache[i] = 4*cache[i/2];
            }else{
                cache[i] = 4*cache[i/2]+1;
            }
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
        MoserDeBruijnSeq seq = new MoserDeBruijnSeq();
        int n = 10;
        seq.genSeq(n);
    }
}