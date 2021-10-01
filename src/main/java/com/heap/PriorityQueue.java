package main.java.com.heap;

public class PriorityQueue {
    int[] elePQ;

    /*
     * Insert element into the Priority Queue
     * The insertion is done based on the priority
     * The priority decision is taken in heapify method
     */
    public void insert(int ele){
        if(elePQ==null || elePQ.length==0){
            elePQ = new int[1];
            elePQ[0] = ele;
        }else{
            int[] tmp = new int[elePQ.length+1];
            System.arraycopy(elePQ, 0, tmp, 0, elePQ.length);
            tmp[tmp.length-1] = ele;
            heapifyParentChild(tmp, tmp.length-1);
            elePQ = tmp;
            tmp = null;
        }
    }

    /*
     * Return and removes the highest priority element
     * Also make sure that the next second highest
     * element becomes the highest prioritized element
     * Throws Runtime Exception in case Queue is empty
     */
    public int removeMax(){
        if(!empty()){
            int maxPriorityEle = -1;

            if(elePQ.length==1) {
                maxPriorityEle = elePQ[0];
                elePQ = null;
                return maxPriorityEle;
            }
            maxPriorityEle = elePQ[0];
            int tmp = elePQ[0];
            elePQ[0] = elePQ[elePQ.length-1];
            elePQ[elePQ.length-1] = tmp;
            int[] tmpArr = new int[elePQ.length-1];
            System.arraycopy(elePQ, 0, tmpArr, 0, elePQ.length-1);
            heapifyMax(tmpArr, 0);
            elePQ = tmpArr;
            return maxPriorityEle;
        }else{
            throw new RuntimeException("Priority Queue is empty");
        }
    }

    /*
     * Returns true if the Priority Queue is empty
     */
    public boolean empty(){
        if(elePQ==null || elePQ.length==0) {
            return true;
        }else{
            return false;
        }
    }

    private void heapifyParentChild(int[] arr, int index){
        int parentIdx = (index-1)/2;
        if(parentIdx>=0 && arr[parentIdx]<arr[index]){
            int tmp = arr[parentIdx];
            arr[parentIdx] = arr[index];
            arr[index] = tmp;
            heapifyParentChild(arr, parentIdx);
        }
    }

    private void heapifyMax(int arr[], int index){
        int largestId = index;
        int lChildId = (2*index) + 1;
        int rChildId = (2*index) + 2;

        if(lChildId<arr.length && arr[lChildId]>arr[index]){
            largestId = lChildId;
        }
        if(rChildId<arr.length && arr[largestId]<arr[rChildId]){
            largestId = rChildId;
        }
        if(largestId!=index){
            int tmp = arr[index];
            arr[index] = arr[largestId];
            arr[largestId] = tmp;
            heapifyMax(arr, largestId);
        }
    }

    private void print(int[] arr){
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args){
        PriorityQueue priorityQueue = new PriorityQueue();
        /*priorityQueue.insert(35);
        priorityQueue.insert(26);
        priorityQueue.insert(33);
        priorityQueue.insert(15);
        priorityQueue.insert(24);
        priorityQueue.insert(5);
        priorityQueue.insert(4);
        priorityQueue.insert(12);
        priorityQueue.insert(1);
        priorityQueue.insert(23);
        priorityQueue.insert(21);
        priorityQueue.insert(2);
        priorityQueue.insert(34);*/
        int[] arr = {1,4,3,7,8,9};
        for(int e : arr){
            priorityQueue.insert(e);
        }
        System.out.println("Elements of Priority Queue are ");
        priorityQueue.print(priorityQueue.elePQ);
        System.out.println("Highest Priority Element is : " + priorityQueue.removeMax());
        System.out.println("Is Queue empty : " + priorityQueue.empty());
        System.out.println("Highest Priority Element is : " + priorityQueue.removeMax());
        System.out.println("Is Queue empty : " + priorityQueue.empty());
        System.out.println("Highest Priority Element is : " + priorityQueue.removeMax());
        System.out.println("Is Queue empty : " + priorityQueue.empty());
    }
}