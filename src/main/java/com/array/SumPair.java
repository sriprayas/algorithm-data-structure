package main.java.com.array;

import java.util.HashSet;

public class SumPair {

    private void printPair(int[] arr, int sum){
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < arr.length; ++i)
        {
            int temp = sum - arr[i];

            // checking for condition
            if (s.contains(temp)) {
                System.out.println(
                        "Pair with given sum "
                                + sum + " is (" + arr[i]
                                + ", " + temp + ")");
            }
            s.add(arr[i]);
        }
    }

    public static void main(String[] args){
        SumPair ele = new SumPair();
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int n = 16;
        ele.printPair(arr, n);
    }
}
