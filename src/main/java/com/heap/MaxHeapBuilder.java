package main.java.com.heap;

public class MaxHeapBuilder {

    public void buildMaxHeap(int[] arr){
        int start = arr.length/2;
        for(int i=start; i>=0; i--){
            doMaxHeapify(arr, i);
        }
    }

    private void doMaxHeapify(int[] arr, int idx){
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
        MaxHeapBuilder builder = new MaxHeapBuilder();
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        System.out.println("Elements before ");
        builder.print(arr);
        System.out.println("Elements after ");
        builder.buildMaxHeap(arr);
        builder.print(arr);
    }
}
