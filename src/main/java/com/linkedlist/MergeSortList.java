package main.java.com.linkedlist;

public class MergeSortList {
    Node head;

    static class Node{
        int data;
        Node nxt;
        Node(int data){
            this.data = data;
        }
    }

    public Node sort(Node head){
        // Base Condition
        if(head==null || head.nxt==null){
            return head;
        }
        // Find Mid
        Node mid = findMiddle(head);
        Node midNxt = mid.nxt;
        // Left = Head will be head & tail would be mid, -> mid.nxt = null
        mid.nxt = null;
        // Right = Mid.nxt to tail
        // Sort for Left
        Node left = sort(head);
        // Sort for Right
        Node right = sort(midNxt);
        // Merge the two & return head
        return mergeSortList(left, right);
    }

    public Node mergeSortList(Node head1, Node head2){
        Node res = null;
        if(head1 == null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.data< head2.data){
            res = head1;
            res.nxt = mergeSortList(head1.nxt, head2);
        }else{
            res = head2;
            res.nxt = mergeSortList(head1, head2.nxt);
        }
        return res;
    }

    public Node findMiddle(Node head){
        Node fast = head;
        Node slow = head;
        while(fast.nxt!=null && fast.nxt.nxt!=null){
            fast = fast.nxt.nxt;
            slow = slow.nxt;
        }
        return slow;
    }

    public static void main(String[] args){
        Node head = new Node(15);
        Node n1 = new Node(10);
        Node n2 = new Node(5);
        Node n3 = new Node(20);
        Node n4 = new Node(3);
        //Node n5 = new Node(2);
        head.nxt = n1;
        n1.nxt = n2;
        n2.nxt = n3;
        n3.nxt = n4;
        //n4.nxt = n5;
        MergeSortList list = new MergeSortList();
        list.print(list.sort(head));
    }

    public void print(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.nxt;
        }
        System.out.println(System.lineSeparator());
    }
}
