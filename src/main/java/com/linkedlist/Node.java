package main.java.com.linkedlist;

public class Node {
    protected int data;
    protected Node next;

    public Node(int data){
        this.data = data;
    }

    public static void printList(Node head){
        while(head!=null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println(System.lineSeparator());
    }
}
