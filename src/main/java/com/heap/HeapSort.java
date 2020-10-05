package main.java.com.heap;

public class HeapSort {

    public void sort(int[] arr){
        buildMaxHeap(arr);
        for(int i=arr.length-1; i>=0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            doMaxHeapify(arr, 0, i);
        }
    }

    public void buildMaxHeap(int[] arr){
        int start = arr.length/2;
        for(int i=start; i>=0; i--){
            doMaxHeapify(arr, i, arr.length);
        }
    }

    private void doMaxHeapify(int[] arr, int idx, int sizeCdr){
        int largeIdx = idx;
        int lChildIdx = (2*idx) + 1;
        int rChildIdx = (2*idx) + 2;

        if(lChildIdx<sizeCdr && arr[lChildIdx]>arr[idx]){
            largeIdx = lChildIdx;
        }

        if(rChildIdx<sizeCdr && arr[rChildIdx]>arr[largeIdx]){
            largeIdx = rChildIdx;
        }

        if(largeIdx!=idx){
            int tmp = arr[idx];
            arr[idx] = arr[largeIdx];
            arr[largeIdx] = tmp;
            doMaxHeapify(arr, largeIdx,sizeCdr);
        }
    }

    private void print(int[] arr){
        for(int e : arr){
            System.out.print(e + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int[] arr = {4, 3, 7, 1, 8, 5};
        HeapSort heapSort = new HeapSort();
        System.out.println("Elements before");
        heapSort.print(arr);
        System.out.println("Elements after");
        heapSort.sort(arr);
        heapSort.print(arr);
    }
}
