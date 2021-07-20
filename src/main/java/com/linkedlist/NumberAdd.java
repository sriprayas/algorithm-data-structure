package main.java.com.linkedlist;

public class NumberAdd {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node getSum(Node headNode1, Node headNode2){
        int num1 = getNumFromList(headNode1);
        int num2 = getNumFromList(headNode2);
        int sum = num1 + num2;

        Node res = new Node(sum%10);
        Node tmp = res;
        sum=sum/10;

        while(sum!=0){
            res.next = new Node(sum%10);
            sum = sum/10;
            res = res.next;
        }
        return tmp;
    }

    public int getNumFromList(Node head){
        int fact = 1;
        int num = 0;
        while(head!=null){
            num = num + fact*head.data;
            fact *=10;
            head=head.next;
        }
        return num;
    }

    public void print(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head=head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args){
        NumberAdd num = new NumberAdd();
        Node head1 = new Node(5);
        Node n11 = new Node(6);
        Node n12 = new Node(3);
        head1.next = n11;
        n11.next = n12;
        num.print(head1);

        Node head2 = new Node(8);
        Node n21 = new Node(4);
        Node n22 = new Node(2);
        head2.next = n21;
        n21.next = n22;
        num.print(head2);

        num.print(num.getSum(head1,head2));

    }

}
