package main.java.com.tree.bst;

public class BSTChecker {
    Node prev;

    static class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    boolean isBST(Node root)
    {
        if (root == null) {
            return true;
        }
        boolean left = isBST(root.left);
        if (prev != null && root.data <= prev.data) {
            return false;
        }
        prev = root;
        boolean right = isBST(root.right);
        return left && right;
    }

    public static void main(String[] args){
        BSTChecker bst = new BSTChecker();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (bst.isBST(root)) {
            System.out.println("IS BST");
        }
        else{
            System.out.println("Not a BST");
        }
    }
}
