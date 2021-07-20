package main.java.com.linkedlist;

public class InsertElement {

    public Node insertHead(Node head, Node newNode) {
        newNode.next = head;
        return newNode;
    }

    public void insertInBetween(Node head, Node newNode, int dist){
        Node prev = null;
        while(head!=null && dist!=0){
            prev = head;
            head = head.next;
            dist--;
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }

    public void insertTail(Node head, Node newNode) {
        while(head.next!=null){
            head = head.next;
        }
        head.next = newNode;
    }

    public static void main(String[] args){
        Node head = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        head.next = n2;
        n2.next = n3;
        System.out.println("Default List ");
        Node.printList(head);

        InsertElement insert = new InsertElement();
        head = insert.insertHead(head, new Node(1));
        insert.insertInBetween(head, new Node(4), 2);
        insert.insertTail(head, new Node(10));

        System.out.println("After update list ");
        Node.printList(head);
    }

}
