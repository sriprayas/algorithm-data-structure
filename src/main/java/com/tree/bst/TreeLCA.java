package main.java.com.tree.bst;

public class TreeLCA {
    static class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    public Node getLCA(Node root, Node x, Node y) {
        if(root==null){
            return null;
        }
        if(x.data<root.data && y.data<root.data){
            return getLCA(root.left, x, y);
        }
        if (x.data>root.data && y.data>root.data){
            return getLCA(root.right, x, y);
        }
        return root;
    }

    public static void main(String[] args){
        TreeLCA tree = new TreeLCA();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        Node n1 = new Node(10);
        Node n2 = new Node(14);
        Node t = tree.getLCA(root, n1, n2);
        System.out.println("LCA of " + n1.data + " and " + n2.data + " is " + t.data);

        n1.data = 14;
        n2.data = 8;
        t = tree.getLCA(root, n1, n2);
        System.out.println("LCA of " + n1.data + " and " + n2.data + " is " + t.data);

        n1.data = 10;
        n2.data = 22;
        t = tree.getLCA(root, n1, n2);
        System.out.println("LCA of " + n1.data + " and " + n2.data + " is " + t.data);
    }
}
