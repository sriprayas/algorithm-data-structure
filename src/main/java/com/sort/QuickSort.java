package main.java.com.sort;

public class QuickSort {

    private int getPivot(int[] arr, int l, int r){
        int pvtNum = arr[r];
        int i=l-1;

        for(int j=l; j<r; j++){
            if(arr[j]<=pvtNum){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];;
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void doSort(int[] arr, int l, int r){
        if(l>=r){
            return;
        }
        int pvt = getPivot(arr, l, r);

        doSort(arr, l, pvt-1);
        doSort(arr, pvt+1, r);
    }

    public static void main(String[] args){
        QuickSort sort = new QuickSort();
        int[] arr = {8,2,3,6};
        sort.print(arr);
        sort.doSort(arr, 0, arr.length-1);
        sort.print(arr);
    }

    private void print(int[] arr){
        for(int e : arr){
            System.out.print(e + " ");
        }
        System.out.println(" ");
    }
}
