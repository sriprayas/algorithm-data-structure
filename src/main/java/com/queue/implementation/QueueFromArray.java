package main.java.com.queue.implementation;

public class QueueFromArray {
    int[] queueArr;
    int front;
    int rear;
    int size;
    int capacity;

    QueueFromArray(int capacity){
        this.capacity = capacity;
        queueArr = new int[capacity];
        this.front = 0;
        this.rear = capacity-1;
        this.size = 0;
    }

    private void enqueue(int data){
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        rear = (rear+1)%capacity;
        queueArr[rear] = data;
        size++;
    }

    private int rear(){
        return queueArr[rear];
    }

    private int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int res = queueArr[front];
        front = (front+1)%capacity;
        size--;
        return res;
    }

    private int front(){
        return queueArr[front];
    }

    private boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    private boolean isFull(){
        if(size==capacity){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        QueueFromArray queue = new QueueFromArray(1000);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.dequeue()
                + " dequeued from queue\n");
        System.out.println("Front item is "
                + queue.front());

        System.out.println("Rear item is "
                + queue.rear());
    }

}
