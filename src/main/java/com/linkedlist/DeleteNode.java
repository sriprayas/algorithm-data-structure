package main.java.com.linkedlist;

public class DeleteNode {

    public void deleteByVal(Node delNode, Node head) {
        Node prevNode = null;
        while(head.data != delNode.data){
            prevNode = head;
            head = head.next;
        }
        prevNode.next = head.next;
    }

    public void deleteByDist(int dist, Node head){
        Node prevNode = null;
        while(head!=null && dist!=0 ){
            prevNode = head;
            head = head.next;
            dist--;
        }
        if(head!=null){
            prevNode.next = head.next;
        }
    }

    public static void main(String[] args){
        Node head = new Node(2);
        Node n2 = new Node(5);
        Node n3 = new Node(8);
        Node n4 = new Node(10);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println("Default List ");
        Node.printList(head);
        DeleteNode deleteNode = new DeleteNode();

        /*System.out.println("Delete node by value");
        Node delNode = new Node(5);
        if(head.data == delNode.data){
            head = head.next;
        }else{
            deleteNode.deleteByVal(delNode, head);
        }
        Node.printList(head);*/

        System.out.println("Delete node by distance");
        int dist = 3;
        if(dist==0){
            head = head.next;
        }else{
            deleteNode.deleteByDist(dist, head);
        }
        Node.printList(head);
    }
}
