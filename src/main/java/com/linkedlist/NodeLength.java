package main.java.com.linkedlist;

public class NodeLength {
    public int getLength(Node head){
        int len =0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        head.next = n2;
        n2.next = n3;
        NodeLength node = new NodeLength();
        System.out.println("The length is " + node.getLength(head));
    }
}
