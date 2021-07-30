package main.java.com.queue.implementation;

public class DeQueueFromArray {
    int front=-1;
    int rear=-1;
    int[] dQArr;
    int size;

    DeQueueFromArray(int size){
        dQArr = new int[size];
        this.size = size;
    }

    private void insertAtRear(int data){
        if(isFull()) {
            throw new RuntimeException("DeQueue is full");
        }
        if(front==-1 & rear==-1) {
            front = rear = 0;
            dQArr[rear] = data;
        }else if(rear == size-1) {
            rear = 0;
            dQArr[rear] = data;
        }else {
            rear++;
            dQArr[rear] = data;
        }
    }

    private void insertAtFront(int data){
        if(isFull()){
            throw new RuntimeException("DeQueue is full");
        }
        if(front == -1 && rear == -1){
            front = rear = 0;
            dQArr[front] = data;
        }else if(front == 0) {
            front = size-1;
            dQArr[front] = data;
        }else {
            front--;
            dQArr[front] = data;
        }
    }

    private int removeFromRear(){
        if(isEmpty()){
            throw new RuntimeException("DqQueue is empty");
        }
        int res = Integer.MAX_VALUE;
        if(front == rear) {
            res = dQArr[rear];
            front = rear = -1;
        }else if(rear == 0) {
            res = dQArr[rear];
            rear = size-1;
        }else{
            res = dQArr[rear];
            rear--;
        }
        return res;
    }

    private int removeFromFront(){
        if(isEmpty()){
            throw new RuntimeException("DqQueue is empty");
        }
        int res = Integer.MAX_VALUE;
        if(front == rear) {
            res = dQArr[front];
            front = rear = -1;
        }else if(front == size-1) {
            res = dQArr[front];
            front = 0;
        }else{
            res = dQArr[front];
            front++;
        }
        return res;
    }

    private int getFront(){
        return dQArr[front];
    }

    private int getRear(){
        return dQArr[rear];
    }

    private boolean isFull(){
        if((rear==size-1 && front==0) || (front==rear+1)){
            return true;
        }else{
            return false;
        }
    }

    private boolean isEmpty(){
        if(front == -1){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        DeQueueFromArray dq = new DeQueueFromArray(5);
        System.out.println("Insert element at rear end  : 5 ");
        dq.insertAtRear(5);

        System.out.println("insert element at rear end : 10 ");
        dq.insertAtRear(10);

        System.out.println("get rear element : "+ dq.getRear());

        dq.removeFromRear();
        System.out.println("After delete rear element new rear become : " +
                dq.getRear());

        System.out.println("inserting element at front end");
        dq.insertAtFront(15);

        System.out.println("get front element: " +dq.getFront());

        dq.removeFromFront();

        System.out.println("After delete front element new front become : " +
                +  dq.getFront());
    }

}
