package main.java.com.linkedlist;

public class RotateList {
    Node head;

    static class Node{
        int data;
        Node nxt;
        Node(int data){
            this.data = data;
        }
    }

    public Node rotate(Node head, int k) {
        Node startNode = head;
        Node endNode = null;

        while(k!=0){
            endNode = head;
            head = head.nxt;
            k--;
        }
        endNode.nxt = null;

        Node res = head;
        while(head.nxt!=null){
            head=head.nxt;
        }
        head.nxt = startNode;

        return res;
    }

    public void print(Node head){
        while(head!=null) {
            System.out.print(head.data + " ");
            head = head.nxt;
        }
        System.out.println(" ");
    }

    public static void main(String[] args){
        Node head = new Node(10);
        Node n1 = new Node(20);
        Node n2 = new Node(30);
        Node n3 = new Node(40);
        Node n4 = new Node(50);
        Node n5 = new Node(60);
        head.nxt = n1;
        n1.nxt = n2;
        n2.nxt = n3;
        n3.nxt = n4;
        n4.nxt = n5;
        RotateList rList = new RotateList();
        System.out.println("Original node");
        rList.print(head);
        rList.print(rList.rotate(head, 4));
    }
}
