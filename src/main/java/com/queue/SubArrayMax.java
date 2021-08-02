package main.java.com.queue;

import java.util.Deque;
import java.util.LinkedList;

public class SubArrayMax {

    private void printMaxElement(int[] arr, int k){
        Deque<Integer> dQ = new LinkedList<>();
        int i=0;
        for (; i<k; ++i){
            while(!dQ.isEmpty() && arr[i] >= arr[dQ.peekLast()]){
                dQ.removeLast();
            }
            dQ.addLast(i);
        }

        for(; i<arr.length; ++i) {
            System.out.print(arr[dQ.peekFirst()] + " ");

            if((!dQ.isEmpty()) && i-k>=dQ.peekFirst()){
                dQ.removeFirst();
            }

            while(!dQ.isEmpty() && arr[i] >= arr[dQ.peekLast()]){
                dQ.removeLast();
            }
            dQ.addLast(i);
        }
        System.out.print(arr[dQ.peek()] + " ");
    }

    public static void main(String[] args){
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        SubArrayMax subArray = new SubArrayMax();
        subArray.printMaxElement(arr, k);
    }
}
