package main.java.com.heap;

public class MaxHeapify {

    public void doMaxHeapify(int[] arr, int idx){
        int largeIdx = idx;
        int lChildIdx = (2*idx) + 1;
        int rChildIdx = (2*idx) + 2;

        if(lChildIdx<arr.length && arr[lChildIdx]>arr[idx]){
            largeIdx = lChildIdx;
        }

        if(rChildIdx<arr.length && arr[rChildIdx]>arr[largeIdx]){
            largeIdx = rChildIdx;
        }

        if(largeIdx!=idx){
            int tmp = arr[idx];
            arr[idx] = arr[largeIdx];
            arr[largeIdx] = tmp;
            doMaxHeapify(arr, largeIdx);
        }
    }

    private void print(int[] arr){
        for(int e : arr){
            System.out.print(e + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        MaxHeapify mxHeapify = new MaxHeapify();
        int[] arr = {4, 7, 8, 3, 2, 6, 5};
        System.out.println("User elements before");
        mxHeapify.print(arr);
        mxHeapify.doMaxHeapify(arr, 0);
        System.out.println("User elements after");
        mxHeapify.print(arr);
    }

}
