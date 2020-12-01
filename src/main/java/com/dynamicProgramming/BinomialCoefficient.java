package main.java.com.dynamicProgramming;

public class BinomialCoefficient {
    public int getCoefficient(int n, int k){
        int[] cache = new int[n+1];
        cache[0] = 1;
        for(int i=1; i<=n ; i++){
            cache[i] = i * cache[i-1];
        }
        int res = (cache[n])/(cache[k] * cache[n-k]);
        return res;
    }

    public static void main(String[] args){
        BinomialCoefficient binomial = new BinomialCoefficient();
        int n = 7;
        int k = 3;
        System.out.println("Binomial Coefficient is " + binomial.getCoefficient(n, k));
    }
}
