package main.java.com.tree;

public class DiameterForBinaryTree {
    int dia;

    static class Node {
        Node lft;
        Node rgt;
        int data;
        Node(int data){
            this.data = data;
        }
    }

    private int setDiameter(Node root){
        if(root == null) {
            return 0;
        }
        int lftHeight = setDiameter(root.lft);
        int rgtHeight = setDiameter(root.rgt);
        dia = Math.max(dia, (lftHeight + rgtHeight + 1));
        return Math.max(lftHeight,rgtHeight) + 1;
    }

    public static void main(String[] args){
        DiameterForBinaryTree bt = new DiameterForBinaryTree();
        Node root = new Node(1);
        root.lft = new Node(2);
        root.rgt = new Node(3);
        root.lft.lft = new Node(4);
        root.lft.rgt = new Node(5);
        bt.setDiameter(root);
        System.out.println("Diameter is " + bt.dia);
    }
}
