package main.java.com.tree;

public class NodeAncestor {

    static class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private boolean printAncestor(Node root, int tgt){
        if(root==null){
            return false;
        }

        if(root.data == tgt){
            System.out.println(root.data);
            return true;
        }

        if(printAncestor(root.left, tgt)
                || printAncestor(root.right, tgt)){
            System.out.println(root.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        NodeAncestor ancestor = new NodeAncestor();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        ancestor.printAncestor(root, 7);
    }
}