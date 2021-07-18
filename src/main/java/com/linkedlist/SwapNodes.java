package main.java.com.linkedlist;

public class SwapNodes {
    Node head;

    public void swapNode(int x, int y) {
        if(x==y) return;

        Node prevX = null;
        Node prevY = null;
        Node currX = head;
        Node currY = head;

        while(currX!=null && currX.data!=x){
            prevX = currX;
            currX = currX.next;
        }

        while(currY!=null && currY.data!=y){
            prevY = currY;
            currY = currY.next;
        }

        if(prevX!=null){
            prevX.next = currY;
        }else{
            head = currY;
        }

        if(prevY!=null){
            prevY.next = currX;
        }else{
            head = currX;
        }

        Node tmp = currY.next;
        currY.next = currX.next;
        currX.next = tmp;
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList(){
        System.out.println("List is ");
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data + " ");
            currNode=currNode.next;
        }
        System.out.println(System.lineSeparator());
    }

    public static void main(String[] args){
        SwapNodes list = new SwapNodes();
        int[] arr = {2 ,5, 8, 10, 12};
        for(int ele : arr){
            list.push(ele);
        }
        int x = 10;
        int y = 8;
        list.printList();
        System.out.println("Swap nodes X = " + x + " and Y = " + y);
        list.swapNode(10, 8);
        System.out.println(System.lineSeparator());
        list.printList();
    }


}
