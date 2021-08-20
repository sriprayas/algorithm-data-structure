package main.java.com.tree;

public class SubOfBinaryTree {
    static class Node {
        Node left;
        Node right;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private boolean isSubTree(Node r1, Node r2) {
        if(r2 == null){
            return false;
        }
        if(r1==null){
            return false;
        }
        if(isIdentical(r1, r2)){
            return true;
        }
        return ( isSubTree(r1.left, r2) || isSubTree(r1.right, r2) );
    }

    private boolean isIdentical(Node n1, Node n2){
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2==null){
            return false;
        }
        return ( (n1.data==n2.data) &&
                isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right));
    }

    public static void main(String[] args){
        SubOfBinaryTree tree = new SubOfBinaryTree();
        Node root1 = new Node(26);
        root1.right = new Node(3);
        root1.right.right = new Node(3);
        root1.left = new Node(10);
        root1.left.left = new Node(4);
        root1.left.left.right = new Node(30);
        root1.left.right = new Node(6);

        Node root2 = new Node(10);
        root2.right = new Node(6);
        root2.left = new Node(4);
        root2.left.right = new Node(30);

        if(tree.isSubTree(root1, root2)){
            System.out.println("It is sub tree");
        }else{
            System.out.println("It is not sub tree");
        }
    }
}
