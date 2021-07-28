package main.java.com.queue.implementation;

public class QueueFromLinkedList {
    Node front;
    Node rear;

    class Node{
        Node nxt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void enqueue(int data){
        Node tmp = new Node(data);
        if(front==null){
            front = tmp;
        }else{
            rear.nxt = tmp;
        }
        rear = tmp;
    }

    private int dequeue(){
        if(front==null ) {
            throw new RuntimeException("Underflow");
        }
        int res = front.data;
        front = front.nxt;
        return res;
    }

    private int front(){
        if(front==null ) {
            throw new RuntimeException("Queue is empty");
        }
        return front.data;
    }

    private int rear(){
        if(rear==null ) {
            throw new RuntimeException("Queue is empty");
        }
        return rear.data;
    }

    public static void main(String[] args){
        QueueFromLinkedList q = new QueueFromLinkedList();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Queue Front : " + q.dequeue());
        System.out.println("Queue Front : " + q.dequeue());
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println("Queue Front : " + q.dequeue());
        System.out.println("Queue Front : " + q.front());
        System.out.println("Queue Rear : " + q.rear());
    }
}
