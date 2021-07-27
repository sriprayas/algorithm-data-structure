package main.java.com.stack;

public class StackMiddle {
    Node head;
    Node mid;
    int size;

    class Node{
        Node prv;
        Node nxt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void push(int ele){
        Node tmp = new Node(ele);
        if(head!=null){
            tmp.nxt = head;
            head.prv = tmp;
        }
        head = tmp;

        size++;
        if(size==1){
            mid = head;
        }else if(size%2!=0){
            mid=mid.prv;
        }
    }

    private int pop(){
        if(head==null) throw new RuntimeException("Stack is empty");

        int res = head.data;
        head = head.nxt;
        size--;
        if(size%2==0){
            mid=mid.nxt;
        }
        return res;
    }

    private int findMiddle(){
        if(size==1) {
            return head.data;
        }
        return mid.data;
    }

    private void deleteMiddle(){
        if(size==1) head = null;
        Node tmpMid = null;
        if(size%2==0){
            tmpMid = mid.prv;
        }else{
            tmpMid = mid.nxt;
        }
        mid.prv.nxt = mid.nxt;
        mid.nxt.prv = mid.prv;
        mid = tmpMid;
    }

    public static void main(String[] args){
        StackMiddle stack = new StackMiddle();
        int[] arr = {11,22,33,44,55,66,77};
        for(int ele : arr){
            stack.push(ele);
        }
        System.out.println("Middle element is " + stack.findMiddle());
        stack.deleteMiddle();
        System.out.println("Middle element is " + stack.findMiddle());
    }
}
