package main.java.com.array;

public class MissingElement {

    private Integer getMissingElement(int[] arr){
        int n = arr.length;
        int x1 = 1;
        for(int i=2; i<=n+1; i++){
            x1 = x1^i;
        }

        int x2 = arr[0];
        for(int i=1; i<n; i++){
            x2 = x2^arr[i];
        }

        return x1^x2;
    }

    public static void main(String[] args){
        MissingElement ele = new MissingElement();
        int[] arr = {1, 2, 3, 5, 6};
        System.out.println("Missing Element is " + ele.getMissingElement(arr));
    }
}
