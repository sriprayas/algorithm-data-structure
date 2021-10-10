package main.java.com.array;

public class SearchRotatedSortedArray {

    private int getIndex(int[] arr, int key){
        int pivot = getPivotIndex(arr);
        if(pivot==-1) return -1;

        if(key<arr[0]){
            return doBinarySearch(arr, pivot, arr.length-1, key);
        }else{
            return doBinarySearch(arr, 0, pivot, key);
        }
    }

    private int getPivotIndex(int[] arr){
        for(int i=1; i<arr.length; i++){
            if(arr[i] < arr[i-1]){
                return i;
            }
        }
        return -1;
    }

    private int doBinarySearch(int[] arr, int lft,
                               int rgt, int key){
        if(lft<=rgt) {
            int mid = lft + (rgt - lft) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key < arr[mid]) {
                return doBinarySearch(arr, 0, mid - 1, key);
            } else {
                return doBinarySearch(arr, mid+1, arr.length-1, key);
            }
        }
        return -1;
    }

    public static void main(String[] args){
        SearchRotatedSortedArray ele = new SearchRotatedSortedArray();
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 5;
        int idx = ele.getIndex(arr, key);
        if(idx==-1){
            System.out.println("Key not found");
        }else{
            System.out.println("Key found at " + idx);
        }
    }
}
