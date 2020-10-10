package main.java.com.tree;

public class PreOrderTraversal {

    public void traversePre(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.getVal() + " ");
        traversePre(node.getLeft());
        traversePre(node.getRight());
    }

    public static void main(String[] args){
        Node root = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        root.setVal(1);
        n1.setVal(2);
        n2.setVal(3);
        n3.setVal(4);
        n4.setVal(5);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        PreOrderTraversal pot = new PreOrderTraversal();
        pot.traversePre(root);
    }
}
