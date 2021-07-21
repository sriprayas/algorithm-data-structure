package main.java.com.linkedlist.circular;

public class Insert {
    Node head;
    Node tail;

    class Node{
        Node nxt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    public void insertAtBegin(int data){
        Node tmp = new Node(data);
        tail.nxt = tmp;
        tmp.nxt = head;
        head = tmp;
        print();
    }

    public void insertInBetween(int preData, int target){
        Node curr = tail;
        Node prev = null;
        Node nxt = null;
        do{
            if(curr.data==preData){
                prev = curr;
                nxt = curr.nxt;
                break;
            }
            curr=curr.nxt;
        }while(curr!=tail);
        Node tmp = new Node(target);
        prev.nxt = tmp;
        tmp.nxt = nxt;
        print();
    }

    public void insertAtEnd(int data){
        Node tmp =new Node(data);
        tmp.nxt = tail.nxt;
        tail.nxt = tmp;
        print();
    }

    public void push(int data){
        Node tmp = new Node(data);
        if(head==null){ // Fix the head
            head = tmp;
        }else{ // When at least one node is there
            tail.nxt = tmp;
        } // Fix the tail
        tail = tmp;
        tmp.nxt = head;
    }


    public static void main(String[] args){
        Insert list = new Insert();
        list.push(1);// Insert in empty list
        list.push(2);
        list.push(3);
        list.print();
        list.insertAtBegin(7);
        list.insertAtEnd(4);
        list.insertInBetween(2,5);
    }

    public void print(){
        Node curr = head;
        do{
            System.out.print(curr.data + " ");
            curr=curr.nxt;
        }while (curr!=head);
        System.out.println(System.lineSeparator());
    }
}
