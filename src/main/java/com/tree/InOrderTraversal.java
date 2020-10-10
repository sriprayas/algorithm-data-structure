package main.java.com.tree;

public class InOrderTraversal {

    public void traverseIn(Node node){
        if(node==null){
            return;
        }
        traverseIn(node.getLeft());
        System.out.print(node.getVal() + " ");
        traverseIn(node.getRight());
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
        InOrderTraversal iot = new InOrderTraversal();
        iot.traverseIn(root);
    }
}
