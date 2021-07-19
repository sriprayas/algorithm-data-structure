package main.java.com.linkedlist;

public class ReverseList {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    Node reverse(Node head){
        Node preNode = null;
        Node nxtNode = head;

        while(nxtNode != null){
            nxtNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nxtNode;
        }
        return preNode;
    }

    public void printList(Node head){
        while(head!=null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args){
        Node head = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        head.next = n2;
        n2.next = n3;
        System.out.println("Default List ");
        ReverseList linkedList = new ReverseList();
        linkedList.printList(head);
        head = linkedList.reverse(head);
        linkedList.printList(head);
    }
}
