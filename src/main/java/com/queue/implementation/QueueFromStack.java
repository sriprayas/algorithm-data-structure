package main.java.com.queue.implementation;

import java.util.Stack;

public class QueueFromStack {

    Stack<Integer> stackQ = new Stack<>();
    Stack<Integer> stackRQ = new Stack<>();

    private void enQueue(int data){
        stackQ.push(data);
        maintainRQ(data);
    }

    private void maintainRQ(int data){
        if(stackRQ.isEmpty()){
            stackRQ.push(data);
        }else{
            int pop = stackRQ.pop();
            maintainRQ(data);
            stackRQ.push(pop);
        }
    }

    private Integer deQueue() {
        return stackRQ.pop();
    }

    public static void main(String[] args) {
        QueueFromStack queue = new QueueFromStack();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
    }
}
