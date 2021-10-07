package main.java.com.array;

public class RotateArray {

    private void rotate(int[] ele, int d){
        reverse(ele, 0, d-1);
        reverse(ele, d, ele.length-1);
        reverse(ele, 0, ele.length-1);
    }

    private void reverse(int[] ele, int start, int end){
        int mid = start + (end-start)/2;
        while(start<=mid){
            int tmp = ele[start];
            ele[start] = ele[end];
            ele[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        RotateArray arr = new RotateArray();
        int[] ele = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        arr.rotate(ele, d);
        for(Integer e : ele){
            System.out.print(e + " ");
        }
    }
}
