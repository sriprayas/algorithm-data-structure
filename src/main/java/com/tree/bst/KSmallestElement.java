package main.java.com.tree.bst;

public class KSmallestElement {
    int idx = 0;
    class Node{
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void printKSmallest(Node root, int k){
        if(root==null){
            return;
        }
        printKSmallest(root.left, k);
        idx++;
        if(idx==k){
            System.out.println("Kth smallest element is " + root.data);
        }
        printKSmallest(root.right, k);
    }

    public Node insert(Node root, int x) {
        if (root == null)
            return new Node(x);
        if (x < root.data)
            root.left = insert(root.left, x);
        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }
    public static void main(String[] args){
        KSmallestElement tree = new KSmallestElement();
        Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

        for (int x : keys)
            root = tree.insert(root, x);

        int k = 5;
        tree.printKSmallest(root, k);
    }
}
