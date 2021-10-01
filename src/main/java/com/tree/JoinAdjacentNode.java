package main.java.com.tree;

public class JoinAdjacentNode {

    static class Node {
        Node left;
        Node right;
        Node nxtRight;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private void connAdj(Node root){
        if(root==null){
            return;
        }

        Node currNode = root;
        Node lftNode = root.left;
        Node rgtNode = root.right;

        if(lftNode != null){
            lftNode.nxtRight = rgtNode;
        }
        if(rgtNode != null && root.nxtRight!=null) {
            rgtNode.nxtRight = root.nxtRight.left;
        }

        connAdj(root.left);
        connAdj(root.right);
    }

    private void printAdjEle(Node root){
        if(root==null){
            return;
        }
        if(root.nxtRight!=null){
            System.out.println("For element " + root.data + " adjacent element is " + root.nxtRight.data);
        }else{
            System.out.println("For element " + root.data + " adjacent element is not present");
        }
        if(root.left!=null){
            printAdjEle(root.left);
        }
        if(root.right!=null){
            printAdjEle(root.right);
        }
    }

    public static void main(String[] args){
        JoinAdjacentNode adj = new JoinAdjacentNode();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        adj.connAdj(root);
        adj.printAdjEle(root);
    }
}
