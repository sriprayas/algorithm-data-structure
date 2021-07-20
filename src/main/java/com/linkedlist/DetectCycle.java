package main.java.com.linkedlist;

public class DetectCycle {
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public boolean isCycleRemoved(Node head){
        // Head
        if(head.next==null) return false;

        boolean res = false;
        Node fast = head.next.next;
        Node slow = head.next;

        // Detect Cycle
        while(fast !=null && fast.next!=null){
            if(slow.data==fast.data){
                res = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        // Remove Cycle
        slow = head;
        if(res){
            if(slow.data!=fast.data){
                while(slow.next!=fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
            }else{
                // If start of the loop is also the head
                while(fast.next!=slow){
                    fast = fast.next; 
                }
            }
            fast.next=null;
        }
        // Return if cycle removed
        return res;
    }

    public void print(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head=head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args){
        DetectCycle list = new DetectCycle();
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        head.next = n1;
        n1.next = head;
        //n2.next = n3;
        //n3.next = n4;
        //n4.next = n2;
        System.out.println("Cycle present " + list.isCycleRemoved(head));
        System.out.println("Cycle present " + list.isCycleRemoved(head));
        list.print(head);
    }
}
