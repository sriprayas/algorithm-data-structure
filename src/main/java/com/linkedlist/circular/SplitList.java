package main.java.com.linkedlist.circular;

public class SplitList {
    Node head;
    Node tail;
    Node head1;
    Node head2;

    class Node{
        int data;
        Node nxt;
        Node(int data){
            this.data=data;
        }
    }

    private void split(){
        Node slw = head;
        Node fst = head;
        while(fst.nxt!=head && fst.nxt.nxt!=head){
            slw=slw.nxt;
            fst=fst.nxt.nxt;
        }
        if(fst.nxt!=head){
            fst=fst.nxt;
        }

        head2=slw.nxt;
        fst.nxt=head2;

        head1 = head;
        slw.nxt = head1;

        printNode(head1);
        printNode(head2);
    }

    private void addNode(int data){
        Node tmp = new Node(data);
        if(head==null){
            head = tmp;
        }else{
            tail.nxt = tmp;
        }
        tail = tmp;
        tmp.nxt = head;
    }

    private void printNode(Node head){
        Node curr = head;
        do{
            System.out.print(curr.data + " ");
            curr = curr.nxt;
        } while(curr!=head);
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args){
        SplitList list = new SplitList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.printNode(list.head);
        list.split();
    }

}
