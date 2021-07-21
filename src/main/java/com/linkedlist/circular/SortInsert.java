package main.java.com.linkedlist.circular;

public class SortInsert {
    Node head;

    class Node{
        int data;
        Node nxt;
        Node(int data){
            this.data = data;
        }
    }

    private void push(int data){
        Node curr = head;
        Node tgt = new Node(data);

        if(curr==null){// Empty List
            head = tgt;
            tgt.nxt = head;
        }else if(data<=curr.data){ // New head
            while(curr.nxt!=head){
                curr=curr.nxt;
            }
            curr.nxt = tgt;
            tgt.nxt = head;
            head = tgt;
        }else{
            while(curr.nxt.data<=data && curr.nxt!=head){ // Insert after head
                curr = curr.nxt;
            }
            tgt.nxt=curr.nxt;
            curr.nxt=tgt;
        }

    }

    public static void main(String[] args){
        SortInsert list = new SortInsert();
        int[] arr = {1,2,3};
        for(int ele : arr){
            list.push(ele);
        }
        list.print();
    }

    private void print(){
        Node curr = head;
        do{
            System.out.print( curr.data + " ");
            curr=curr.nxt;
        } while(curr!=head);
        System.out.println(System.lineSeparator());
    }
}
