package main.java.com.dynamicProgramming;

public class NewmanShanksWilliamsPrime {
    private int getPrime(int n){
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i=2; i<=n; i++){
            c = 2*b + a;
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args){
        NewmanShanksWilliamsPrime number
                = new NewmanShanksWilliamsPrime();
        int n = 4;
        System.out.println("The prime for given " + n
                + " is " + number.getPrime(n));
    }
}
