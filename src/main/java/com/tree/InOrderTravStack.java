package main.java.com.tree;

import java.util.Stack;

public class InOrderTravStack {

    static class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void printNode(Node root){
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args){
        InOrderTravStack iot = new InOrderTravStack();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        iot.printNode(root);
    }
}
