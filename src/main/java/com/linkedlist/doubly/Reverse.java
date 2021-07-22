package main.java.com.linkedlist.doubly;

import main.java.com.linkedlist.ReverseList;

public class Reverse {
    Node head;

    class Node{
        Node prv;
        Node nxt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void reverseList(){
         Node curr = head;
         Node tmp = null;

         while(curr!=null){
             tmp = curr.prv;
             curr.prv = curr.nxt;
             curr.nxt = tmp;
             curr = curr.prv;
         }
         head=tmp.prv;
    }

    private void push(int data){
        Node tmp = new Node(data);
        if(head!=null) {
            tmp.nxt = head;
            head.prv = tmp;
        }
        head=tmp;
    }

    public static void main(String[] args){
        Reverse dList = new Reverse();
        int[] arr = {1,2,3,4,5};
        for(int ele : arr){
            dList.push(ele);
        }
        dList.print();
        dList.reverseList();
        dList.print();
    }

    private void print(){
        Node curr=head;
        while(curr != null){
            if(curr.prv!=null) {
                System.out.print("Prev " + curr.prv.data + " ");
            }else{
                System.out.print("Prev Null ");
            }

            System.out.print("Curr " + curr.data + " ");

            if(curr.nxt!=null) {
                System.out.print("Next " + curr.nxt.data);
            }else{
                System.out.print("Next Null ");
            }
            curr = curr.nxt;
            System.out.println(System.lineSeparator());
        }
        System.out.println(System.lineSeparator());
    }
}
