package main.java.com.queue.optimized;

import java.util.Stack;

public class QueueFromStackOpt {
    Stack<Integer> stackQ = new Stack<>();

    private void enqueue(int data){
        stackQ.push(data);
    }

    private int dequeue(){
        if(stackQ.isEmpty()){
            throw new RuntimeException("Q is empty");
        }else if(stackQ.size()==1){
            return stackQ.pop();
        }else{
            int pop = stackQ.pop();
            int res = dequeue();
            stackQ.push(pop);
            return res;
        }
    }

    public static void main(String[] args){
        QueueFromStackOpt q = new QueueFromStackOpt();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("DQ " + q.dequeue());
        System.out.println("DQ " + q.dequeue());
    }
}
