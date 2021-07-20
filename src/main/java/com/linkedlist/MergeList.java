package main.java.com.linkedlist;

public class MergeList {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node mergeList(Node head1, Node head2){
        Node resHead = null;

        if(head1.data < head2.data){
            resHead = new Node(head1.data);
            head1 = head1.next;
        }else{
            resHead = new Node(head2.data);
            head2 = head2.next;
        }
        Node res = resHead;

        while(head1!=null && head2!=null) {
            if(head1.data < head2.data){
                resHead.next = new Node(head1.data);
                head1 = head1.next;
            }else{
                resHead.next =  new Node(head2.data);
                head2 = head2.next;
            }
            resHead = resHead.next;
        }

        while(head1!=null){
            resHead.next = new Node(head1.data);
            head1 = head1.next;
            resHead = resHead.next;
        }

        while(head2!=null){
            resHead.next = new Node(head2.data);
            head2 = head2.next;
            resHead = resHead.next;
        }

        return res;
    }

    public void print(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head=head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args){
        MergeList merge = new MergeList();

        Node head1 = new Node(2);
        Node n11 = new Node(3);
        Node n12 = new Node(20);
        head1.next = n11;
        n11.next = n12;
        merge.print(head1);

        Node head2 = new Node(5);
        Node n21 = new Node(10);
        Node n31 = new Node(15);
        head2.next = n21;
        n21.next = n31;
        merge.print(head2);

        merge.print(merge.mergeList(head1, head2));

    }
}
