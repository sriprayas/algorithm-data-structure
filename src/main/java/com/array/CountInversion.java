package main.java.com.array;

public class CountInversion {
    static int count;

    private int[] mergeSort(int[] arr, int lo, int hi){
        if(lo==hi){
            int[] tmp = new int[1];
            tmp[0] = arr[lo];
            return tmp;
        }
        int mid = lo + (hi-lo)/2;
        int[] lft = mergeSort(arr, lo, mid);
        int[] rgt = mergeSort(arr, mid+1, hi);
        int[] mrg = mergeLftRgt(lft, rgt);
        return mrg;
    }

    private int[] mergeLftRgt(int[] lft, int[] rgt) {
        int[] mrg = new int[lft.length+rgt.length];
        int l=0;
        int r=0;
        int m=0;

        while(l<lft.length && r<rgt.length) {
            if (lft[l] <= rgt[r]) {
                mrg[m] = lft[l];
                m++;
                l++;
            }else{
                count += (lft.length-l);
                mrg[m] = rgt[r];
                r++;
                m++;
            }
        }

        while(l<lft.length){
            mrg[m] = lft[l];
            m++;
            l++;
        }

        while(r<rgt.length){
            mrg[m] = rgt[r];
            r++;
            m++;
        }
        return mrg;
    }

    public static void main(String[] args){
        CountInversion countInversion = new CountInversion();
        int[] arr = {2,4,1,3,5};
        countInversion.mergeSort(arr, 0, arr.length-1);
        System.out.println(count);
    }
}
