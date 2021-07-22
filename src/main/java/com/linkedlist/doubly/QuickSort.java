package main.java.com.linkedlist.doubly;

public class QuickSort {
    Node head;

    class Node{
        Node prv;
        Node nxt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private Node getPivot(Node lft, Node rgt){
        Node i = lft.prv;
        Node lftCopy = lft;

        while(lft!=rgt){
            if(lft.data<=rgt.data){
                if(i==null){
                    i = lftCopy;
                }else{
                    i=i.nxt;
                }

                swap(i, lft);
            }
            lft=lft.nxt;
        }

        if(i==null){
            i=lftCopy;
        }else{
            i=i.nxt;
        }
        swap (i, rgt);
        return i;
    }

    private void swap(Node x, Node y){
        int tmp = x.data;
        x.data = y.data;
        y.data = tmp;
    }

    private void doQuickSort(Node lft, Node rgt){
        if(rgt!=null && lft!=rgt && lft!=rgt.nxt){
            Node pvt = getPivot(lft, rgt);
            doQuickSort(lft, pvt.prv);
            doQuickSort(pvt.nxt, rgt);
        }
    }

    private void push(int data){
        Node tmp = new Node(data);

        if(head!=null){
            tmp.nxt = head;
            head.prv = tmp;
        }
        head = tmp;
    }

    private void print(){
        Node curr=head;
        while(curr != null){
            if(curr.prv!=null) {
                System.out.print("Prev " + curr.prv.data + " ");
            }else{
                System.out.print("Prev Null ");
            }

            System.out.print("Curr " + curr.data + " ");

            if(curr.nxt!=null) {
                System.out.print("Next " + curr.nxt.data);
            }else{
                System.out.print("Next Null ");
            }
            curr = curr.nxt;
            System.out.println(System.lineSeparator());
        }
        System.out.println(System.lineSeparator());
    }

    public Node findTail(){
        Node curr = head;
        while(curr.nxt!=null){
            curr=curr.nxt;
        }
        return curr;
    }

    public static void main(String[] args){
        QuickSort list = new QuickSort();
        int[] arr = {1,2,3,-3,0,-1};
        for(int ele : arr){
            list.push(ele);
        }
        list.print();
        Node r = list.findTail();
        Node l = list.head;
        list.doQuickSort(l, r);
        list.print();
    }
}
