package main.java.com.linkedlist;

public class ReverseListInSets {
    //Node head;

    static class Node{
        int data;
        Node nxt;
        Node(int data){
            this.data = data;
        }
    }

    public Node reverse(Node head, int k){
        if(head==null){
            return null;
        }

        Node curr = head;
        Node prev = null;
        Node nxt = null;
        int count = 0;
        while(count<k && curr!=null){
            nxt = curr.nxt;
            curr.nxt = prev;
            prev = curr;
            curr = nxt;
            count++;
        }

        if(nxt!=null){
            head.nxt = reverse(nxt, k);
        }

        return prev;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        Node n5 = new Node(6);
        Node n6 = new Node(7);
        head.nxt = n1;
        n1.nxt = n2;
        n2.nxt = n3;
        n3.nxt = n4;
        n4.nxt = n5;
        n5.nxt = n6;
        ReverseListInSets list = new ReverseListInSets();
        list.print(head);
        list.print(list.reverse(head,3));
    }

    public void print(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.nxt;
        }
        System.out.println(System.lineSeparator());
    }
}
