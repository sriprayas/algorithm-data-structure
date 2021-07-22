package main.java.com.linkedlist.doubly;

public class DeleteNode {
    Node head;

    static class Node{
        Node prv;
        Node nxt;
        int data;
        Node(int data){
            this.data=data;
        }
    }

    private void delete(Node tgt){
        Node curr = head;

        while(curr!=null){
            if(curr.data==tgt.data){
                if(curr.prv!=null) {
                    curr.prv.nxt = curr.nxt;
                }
                if(curr.nxt!=null) {
                    curr.nxt.prv = curr.prv;
                    if(curr.data==head.data) {
                        head = curr.nxt;
                    }
                }
                return;
            }
            curr=curr.nxt;
        }
    }

    private void push(int data){
        Node tmp = new Node(data);
        if(head!=null){
            tmp.nxt = head;
            head.prv = tmp;
        }
        head = tmp;
    }

    public static void main(String[] args){
        DeleteNode dList = new DeleteNode();
        int[] arr = {7,8,5,4,1};
        for(int ele : arr){
            dList.push(ele);
        }
        dList.print();
        dList.delete(new Node(5));
        dList.print();
        dList.delete(new Node(1));
        dList.print();
        dList.delete(new Node(7));
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
