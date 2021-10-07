package main.java.com.array;

public class MajorityElement {

    private int getMajorElement(int[] arr){
        int majorEle = 0;
        int cnt = 1;
        // Pass 1
        for(int i=1; i<arr.length; i++){
            if(arr[i]==arr[i-1]){
                cnt++;
            }else if(cnt==0){
                cnt = 1;
                majorEle = i;
            }else{
                cnt--;
            }
        }
        // Pass 2
        int tot=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==arr[majorEle]){
                tot++;
            }
        }

        if(tot>arr.length/2){
            return arr[majorEle];
        }else{
            return -1;
        }
    }

    public static void main(String[] args){
        MajorityElement element = new MajorityElement();
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4};
        int majorityEle = element.getMajorElement(arr);
        if(majorityEle!=-1){
            System.out.println("Majority element is " + majorityEle);
        }else{
            System.out.println("Majority element not present");
        }
    }
}
