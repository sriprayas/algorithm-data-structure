package main.java.com.linkedlist.doubly;

public class MergeSort {
    Node head;

    class Node{
        Node prv;
        Node nxt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private Node sort(Node head){
        if(head==null || head.nxt==null) return head;

        Node mid = getMiddle(head);
        Node midNxt = mid.nxt;

        mid.nxt = null;
        midNxt.prv = null;
        Node a = sort(head);
        Node b = sort(midNxt);
        return compAndMerge(a,b);
    }

    private Node compAndMerge(Node a, Node b){
        Node tmp = null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }

        if(a.data<=b.data){
            tmp = a;
            tmp.nxt = compAndMerge(a.nxt, b);;
            tmp.nxt.prv = tmp;
        }else{
            tmp = b;
            tmp.nxt = compAndMerge(a, b.nxt);
            tmp.nxt.prv = tmp;
        }
        return tmp;
    }

    private Node getMiddle(Node l){
        Node slw = l;
        Node fst = l;
        while(fst.nxt!=null && fst.nxt.nxt!=null){
            slw=slw.nxt;
            fst=fst.nxt.nxt;
        }
        return slw;
    }

    private void pushElement(int data){
        Node tmp = new Node(data);
        if(head!=null){
            tmp.nxt = head;
            head.prv = tmp;
        }
        head = tmp;
    }

    public static void main(String args[]){
        MergeSort dList = new MergeSort();
        int[] arr = {8,1,6,2};
        for(int ele : arr){
            dList.pushElement(ele);
        }
        dList.print(dList.sort(dList.head));
    }

    private void print(Node head){
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
}
