package main.java.com.tree.bst;

import main.java.com.tree.Node;

public class MinimumElement {

    public Integer findMin(Node node){
        if(node.getLeft()==null){
            return node.getVal();
        }
        return findMin(node.getLeft());
    }

    public static void main(String[] args){
        Node root = new Node();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        root.setVal(10);
        n1.setVal(5);
        n2.setVal(19);
        n3.setVal(1);
        n4.setVal(6);
        n5.setVal(17);
        root.setLeft(n1);
        root.setRight(n2);
        n1.setLeft(n3);
        n1.setRight(n4);
        n2.setLeft(n5);
        MinimumElement minEle = new MinimumElement();
        System.out.println("Minimum Key is " + minEle.findMin(root));
    }
}
