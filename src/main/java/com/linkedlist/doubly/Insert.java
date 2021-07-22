package main.java.com.linkedlist.doubly;

public class Insert {
    Node head;

    class Node{
        Node prv;
        Node nxt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void insertHead(int data){
        Node tmp = new Node(data);
        if (head != null) {
            tmp.nxt = head;
            head.prv = tmp;
        }
        head = tmp;
    }

    private void insertBefore(int data, int tgt){
        Node tmp = new Node(data);
        Node curr = head;

        while(curr.data!=tgt && curr.nxt!=null){
            curr = curr.nxt;
        }
        tmp.nxt = curr;
        tmp.prv = curr.prv;
        curr.prv.nxt = tmp;
        curr.prv = tmp;
    }

    private void insertAfter(int data, int tgt){
        Node tmp = new Node(data);
        Node curr = head;
        while(curr.data!=tgt && curr.nxt.nxt!=null){
            curr = curr.nxt;
        }
        tmp.nxt = curr.nxt;
        tmp.prv = curr;
        curr.nxt.prv = tmp;
        curr.nxt = tmp;
    }

    private void insertEnd(int data){
        Node tmp = new Node(data);
        Node curr = head;
        while(curr.nxt!=null){
            curr=curr.nxt;
        }
        curr.nxt = tmp;
        tmp.prv = curr;
    }

    public static void main(String[] args){
        Insert dList = new Insert();
        dList.insertHead(5);
        dList.insertHead(1);
        dList.insertEnd(10);
        dList.insertEnd(20);
        dList.insertBefore(15,20);
        dList.insertAfter(8,5);
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
