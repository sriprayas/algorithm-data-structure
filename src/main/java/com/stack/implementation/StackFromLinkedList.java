package main.java.com.stack.implementation;

public class StackFromLinkedList {
    Node head;

    class Node{
        int data;
        Node nxt;
        Node(int data){
            this.data = data;
        }
    }

    private void push(int data){
        Node tmp = new Node(data);
        tmp.nxt = head;
        head = tmp;
    }

    private int pop(){
        if(head==null) return -1;
        int res = head.data;
        Node tmp = head;
        head= head.nxt;
        tmp = null;
        return res;
    }

    private int peek(){
        if(head==null) return -1;
        return head.data;
    }

    private boolean isEmpty(){
        if(head==null) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        StackFromLinkedList stack = new StackFromLinkedList();
        int[] inp = {1,7,5};
        for(int ele : inp){
            stack.push(ele);
        }
        System.out.println(stack.pop());

        System.out.println(stack.peek());

        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
